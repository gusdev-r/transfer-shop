package com.gusdev.transfershop.gateway;

import com.gusdev.transfershop.core.domain.TransactionPin;

public interface UpdateTransactionPinGw {
    TransactionPin update(TransactionPin transactionPin);
}
