package com.servicedesk.backend.identity.dto;

public record AuthResponse(
        String token,
        String name,
        String email,
        String role
) {
}
