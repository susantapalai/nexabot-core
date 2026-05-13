package com.nexabot.controller;

import com.nexabot.model.Business;
import com.nexabot.model.ChatMessage;
import com.nexabot.repository.ChatMessageRepository;
import com.nexabot.service.BusinessService;
import com.nexabot.service.GeminiService;
import com.nexabot.service.TwilioService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class WhatsAppWebhookController {

    private final GeminiService geminiService;
    private final BusinessService businessService;
    private final TwilioService twilioService;
    private final ChatMessageRepository chatMessageRepository;

    public WhatsAppWebhookController(
            GeminiService geminiService,
            BusinessService businessService,
            TwilioService twilioService,
            ChatMessageRepository chatMessageRepository) {
        this.geminiService = geminiService;
        this.businessService = businessService;
        this.twilioService = twilioService;
        this.chatMessageRepository = chatMessageRepository;
    }

    @PostMapping(
            value = "/whatsapp",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String receiveMessage(
            @RequestParam("Body") String body,
            @RequestParam("From") String from,
            @RequestParam(value = "BusinessId", defaultValue = "1") String businessId
    ) {
        try {
            Business business = businessService.getById(Long.parseLong(businessId));
            String context = businessService.buildContext(business);
            String reply = geminiService.chat(body, context);

            ChatMessage message = new ChatMessage();
            message.setBusinessId(business.getId());
            message.setCustomerPhone(from);
            message.setUserMessage(body);
            message.setBotReply(reply);
            chatMessageRepository.save(message);

            String cleanPhone = from.replace("whatsapp:", "");
            twilioService.sendWhatsAppMessage(cleanPhone, reply);

            return "OK";

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}