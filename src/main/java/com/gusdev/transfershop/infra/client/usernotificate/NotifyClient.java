package com.gusdev.transfershop.infra.client.usernotificate;

import com.gusdev.transfershop.infra.client.usernotificate.response.NotifyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "NotifyClient", url = "https://run.mocky.io/v3/dec52ff6-c000-40d9-8e7f-5610b7fc73c4")
public interface NotifyClient {

    @GetMapping
    NotifyResponse notifyClient();
}
