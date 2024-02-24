package com.gusdev.transfershop.gateway;

import com.gusdev.transfershop.core.domain.TransactionPin;

public interface ValidateTransactionPinGw {
    boolean validate(TransactionPin transactionPin, String pin);
}
