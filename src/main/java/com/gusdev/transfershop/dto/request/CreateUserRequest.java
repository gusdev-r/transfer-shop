package com.gusdev.transfershop.dto.request;

import com.gusdev.transfershop.domain.enums.UserType;

public record CreateUserRequest(String email, String password, String taxNumber, String fullName, UserType type, String pin) {
}
