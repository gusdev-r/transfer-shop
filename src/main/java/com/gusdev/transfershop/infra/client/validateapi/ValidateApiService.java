package com.gusdev.transfershop.infra.client.validateapi;

import com.gusdev.transfershop.infra.client.validateapi.response.ValidateApiResponse;
import org.springframework.stereotype.Service;

@Service
public class ValidateApiService {
    private ValidateApiClient validateApiClient;

    public ValidateApiService(ValidateApiClient validateApiClient) {
        this.validateApiClient = validateApiClient;
    }
    public ValidateApiResponse validate() {
        try {
            return validateApiClient.validate();
        } catch (Exception e) {
            return null;
        }
    }
}
