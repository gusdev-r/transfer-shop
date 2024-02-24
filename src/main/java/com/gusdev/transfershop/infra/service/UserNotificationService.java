package com.gusdev.transfershop.infra.service;

import com.gusdev.transfershop.core.domain.Transaction;
import com.gusdev.transfershop.gateway.UserNotificationGw;
import com.gusdev.transfershop.infra.client.usernotificate.NotifyClientService;
import org.springframework.stereotype.Service;

import static com.gusdev.transfershop.infra.utils.Utility.LOGGER;

@Service
public class UserNotificationService implements UserNotificationGw {
    private NotifyClientService notifyClientService;

    public UserNotificationService(NotifyClientService notifyClientService) {
        this.notifyClientService = notifyClientService;
    }
    @Override
    public Boolean notify(Transaction transaction, String email) {
        LOGGER.info("Starting the notification process of the user - UserNotificationService");
        var response = notifyClientService.notifyClient();
        if (response == true) {
            LOGGER.info("User notified successfully. - UserNotificationService");
        }
        return response;
    }
}
