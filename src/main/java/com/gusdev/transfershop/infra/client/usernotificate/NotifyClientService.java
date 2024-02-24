package com.gusdev.transfershop.infra.client.usernotificate;

import org.springframework.stereotype.Service;

@Service
public class NotifyClientService {
    private NotifyClient notifyClient;

    public NotifyClientService(NotifyClient notifyClient) {
        this.notifyClient = notifyClient;
    }
//    public Boolean notifyClient() {
//        var response = notifyClient.notifyClient();
//        return response.success();
//    }
    public Boolean notifyClient() {
        return notifyClient.notifyClient().success();

    }
}
