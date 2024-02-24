package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.core.domain.Transaction;

public interface UserNotificationUc {
    Boolean notifyUser(Transaction transaction, String email);
}
