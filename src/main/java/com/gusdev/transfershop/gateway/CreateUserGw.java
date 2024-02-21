package com.gusdev.transfershop.gateway;

import com.gusdev.transfershop.domain.User;
import com.gusdev.transfershop.domain.Wallet;

public interface CreateUserGw {
    Boolean create(User user, Wallet wallet);
}
