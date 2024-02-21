package com.gusdev.transfershop.gateway;

import com.gusdev.transfershop.domain.TransactionPin;

public interface TransactionPinValidateGw {
    boolean validate(TransactionPin transactionPin);
}
