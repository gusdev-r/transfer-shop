package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.domain.Transaction;

public interface UserNotificationUc {
    Boolean notifyUser(Transaction transaction, String email);
}
