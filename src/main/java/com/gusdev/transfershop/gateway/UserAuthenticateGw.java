package com.gusdev.transfershop.gateway;

import com.gusdev.transfershop.domain.User;

public interface UserAuthenticateGw {
    Boolean validate(String username, String password);
}
