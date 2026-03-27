package com.servicedesk.backend.identity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_CREATE("admin:create"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete"),

    MANAGER_READ("manager:read"),
    MANAGER_CREATE("manager:create"),
    MANAGER_UPDATE("manager:update"),

    AGENT_READ("agent:read"),
    AGENT_UPDATE("agent:update"),

    CLIENT_READ("client:read"),
    CLIENT_CREATE("client:create");

    private final String permission;
}
