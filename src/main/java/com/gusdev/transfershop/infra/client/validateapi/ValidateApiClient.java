package com.gusdev.transfershop.infra.client.validateapi;

import com.gusdev.transfershop.infra.client.validateapi.response.ValidateApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//import static com.gusdev.transfershop.infra.utils.Utility.LOGGER;

@FeignClient(name = "ValidateApiClient", url = "${client.url}")
public interface ValidateApiClient {

    @GetMapping
    ValidateApiResponse validate();
}
