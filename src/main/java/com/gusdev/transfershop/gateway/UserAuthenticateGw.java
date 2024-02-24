package com.gusdev.transfershop.gateway;

public interface UserAuthenticateGw {
    Boolean validate(String username, String password);
}
