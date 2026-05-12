package com.nexabot.dto;

import lombok.Data;

@Data
public class ChatRequest {
    private String message;
    private String businessId;
}
