package com.gusdev.transfershop.ucimp;

import com.gusdev.transfershop.domain.Transaction;
import com.gusdev.transfershop.gateway.UserNotificationGw;
import com.gusdev.transfershop.usecase.UserNotificationUc;

public class UserNotificationImp implements UserNotificationUc {
    private UserNotificationGw userNotificationGw;

    public UserNotificationImp(UserNotificationGw userNotificationGw) {
        this.userNotificationGw = userNotificationGw;
    }

    @Override
    public Boolean notifyUser(Transaction transaction, String email) {
        return userNotificationGw.notify(transaction, email);
    }
}
