package com.gusdev.transfershop.infra.service;

import com.gusdev.transfershop.core.domain.Transaction;
import com.gusdev.transfershop.gateway.ValidateTransactionGw;
import com.gusdev.transfershop.infra.client.validateapi.ValidateApiService;
import org.springframework.stereotype.Service;

import static com.gusdev.transfershop.infra.utils.Utility.LOGGER;

@Service
public class ValidateTransactionService implements ValidateTransactionGw {
    private ValidateApiService apiService;

    public ValidateTransactionService(ValidateApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Boolean validate(Transaction transaction) {
        LOGGER.info("Starting the validation of the transaction by external service. - ValidateTransactionService");
        var response = apiService.validate();
        if (response == null) {
            LOGGER.info("Rejected Transaction - ValidateTransactionService");
            return false;
        }
        LOGGER.info("Approved transaction - ValidateTransactionService");
        return response.success();
    }
}
