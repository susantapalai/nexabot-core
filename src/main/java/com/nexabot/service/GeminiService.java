package com.nexabot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.api.url}")
    private String apiUrl;

    private final WebClient webClient;

    public GeminiService(WebClient.Builder builder) {
        this.webClient = builder.build();
    }

    public String chat(String userMessage, String businessContext) {

        String prompt = """
                You are a helpful assistant for a local business.
                Only answer based on the following business information:

                %s

                If you don't know the answer, say:
                "Please contact us directly for more information."

                Customer question: %s
                """.formatted(businessContext, userMessage);

        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of("parts", List.of(
                                Map.of("text", prompt)
                        ))
                )
        );

        String fullUrl = apiUrl + "?key=" + apiKey;

        Map response = webClient.post()
                .uri(fullUrl)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        return extractText(response);
    }

    private String extractText(Map response) {
        try {
            var candidates = (List) response.get("candidates");
            var first = (Map) candidates.get(0);
            var content = (Map) first.get("content");
            var parts = (List) content.get("parts");
            var part = (Map) parts.get(0);
            return (String) part.get("text");
        } catch (Exception e) {
            return "Sorry, I could not process your request right now.";
        }
    }
}