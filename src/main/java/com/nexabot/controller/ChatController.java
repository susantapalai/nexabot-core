package com.nexabot.controller;

import com.nexabot.dto.ChatRequest;
import com.nexabot.dto.ChatResponse;
import com.nexabot.model.Business;
import com.nexabot.model.ChatMessage;
import com.nexabot.repository.ChatMessageRepository;
import com.nexabot.service.BusinessService;
import com.nexabot.service.GeminiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatController {

    private final GeminiService geminiService;
    private final BusinessService businessService;
    private final ChatMessageRepository chatMessageRepository;

    public ChatController(GeminiService geminiService,
                          BusinessService businessService,
                          ChatMessageRepository chatMessageRepository) {
        this.geminiService = geminiService;
        this.businessService = businessService;
        this.chatMessageRepository = chatMessageRepository;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        ChatResponse response = new ChatResponse();

        try {
            // 1. Fetch business from DB
            Business business = businessService.getById(
                    Long.parseLong(request.getBusinessId())
            );

            // 2. Build context from DB data
            String context = businessService.buildContext(business);

            // 3. Call Gemini with real context
            String reply = geminiService.chat(request.getMessage(), context);

            // 4. Save conversation to DB
            ChatMessage message = new ChatMessage();
            message.setBusinessId(business.getId());
            message.setUserMessage(request.getMessage());
            message.setBotReply(reply);
            chatMessageRepository.save(message);

            response.setReply(reply);
            response.setSuccess(true);

        } catch (Exception e) {
            response.setSuccess(false);
            response.setError(e.getMessage());
        }

        return response;
    }
}