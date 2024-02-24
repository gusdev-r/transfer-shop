package com.gusdev.transfershop.gateway;

import com.gusdev.transfershop.core.domain.User;
import com.gusdev.transfershop.core.domain.Wallet;

public interface CreateUserGw {
    Boolean create(User user, Wallet wallet);
}
