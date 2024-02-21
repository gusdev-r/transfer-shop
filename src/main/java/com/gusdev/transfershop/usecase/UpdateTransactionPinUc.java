package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.domain.Transaction;
import com.gusdev.transfershop.domain.TransactionPin;

public interface UpdateTransactionPinUc {
    TransactionPin updateTransactionPin (TransactionPin transactionPin);
}
