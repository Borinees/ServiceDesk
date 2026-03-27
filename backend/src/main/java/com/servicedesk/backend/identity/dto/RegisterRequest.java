package com.servicedesk.backend.identity.dto;

import com.servicedesk.backend.identity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRequest(

        @NotBlank(message = "Name is mandatory")
        String name,

        @NotBlank(message = "Email is mandatory")
        String email,

        @NotBlank(message = "Password is mandatory")
        String password,

        @NotNull(message = "Role is mandatory")
        Role role
) {
}
