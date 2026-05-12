package com.nexabot.controller;

import com.nexabot.dto.ChatRequest;
import com.nexabot.dto.ChatResponse;
import com.nexabot.service.GeminiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatController {

    private final GeminiService geminiService;

    public ChatController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {

        // Hardcoded for today — Day 2 we load this from PostgreSQL
        String businessContext = """
                Business Name: Pizza Palace
                Location: MG Road, Pune
                Timings: 11 AM to 11 PM, all days
                Menu:
                - Margherita Pizza: Rs 199 (small), Rs 299 (large)
                - Paneer Tikka Pizza: Rs 249 (small), Rs 369 (large)
                - Veg Supreme: Rs 229 (small), Rs 339 (large)
                Delivery: Free above Rs 399
                Contact: 98765 43210
                """;

        ChatResponse response = new ChatResponse();

        try {
            String reply = geminiService.chat(request.getMessage(), businessContext);
            response.setReply(reply);
            response.setSuccess(true);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setError(e.getMessage());
        }

        return response;
    }
}