package com.gusdev.transfershop.infra.dto.request;

import com.gusdev.transfershop.core.domain.enums.UserType;

public record CreateUserRequest(String email, String password, String taxNumber, String fullName, UserType type, String pin) {
}
