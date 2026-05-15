package com.nexabot.dto;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private String name;
    private String email;
    private Long businessId;
    private boolean success;
    private String error;
}