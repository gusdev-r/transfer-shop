package com.gusdev.transfershop.infra.service;

import com.gusdev.transfershop.core.domain.Transaction;
import com.gusdev.transfershop.core.domain.TransactionPin;
import com.gusdev.transfershop.gateway.ValidateTransactionGw;
import com.gusdev.transfershop.gateway.ValidateTransactionPinGw;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.gusdev.transfershop.infra.utils.Utility.LOGGER;

@Service
public class ValidateTransactionPinService implements ValidateTransactionPinGw {

    @Override
    public boolean validate(TransactionPin transactionPin, String pin) {
        LOGGER.info("Starting the validation of the transaction password - ValidateTransactionPinService");
        if (!Objects.equals(transactionPin.getPin(), pin)){
            LOGGER.info("Incorrect password - ValidateTransactionPinService");
            return false;
        }
        LOGGER.info("Login authorized, correct password - ValidateTransactionPinService");
        return true;
    }
}
