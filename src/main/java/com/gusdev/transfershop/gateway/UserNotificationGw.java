package com.gusdev.transfershop.gateway;

import com.gusdev.transfershop.domain.Transaction;

public interface UserNotificationGw {
    Boolean notify(Transaction transaction, String email);
}
