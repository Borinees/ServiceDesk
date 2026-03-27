package com.servicedesk.backend.identity.dto;

import com.servicedesk.backend.identity.Role;
import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String name,
        String email,
        Role role,
        boolean active,
        LocalDateTime createdAt
        ) {
}
