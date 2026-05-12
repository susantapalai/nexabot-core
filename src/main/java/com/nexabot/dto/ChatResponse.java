package com.nexabot.dto;

import lombok.Data;

@Data
public class ChatResponse {
    private String reply;
    private boolean success;
    private String error;
}