package com.gusdev.transfershop.gateway;

import com.gusdev.transfershop.domain.TransactionPin;

public interface ValidateTransactionPinGw {
    boolean validate(TransactionPin transactionPin);
}
