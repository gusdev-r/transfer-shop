package com.gusdev.transfershop.ucimp;

import com.gusdev.transfershop.core.domain.TransactionPin;
import com.gusdev.transfershop.gateway.UpdateTransactionPinGw;
import com.gusdev.transfershop.usecase.UpdateTransactionPinUc;

public class UpdateTransactionImp implements UpdateTransactionPinUc {
    private UpdateTransactionPinGw transactionPinGw;

    public UpdateTransactionImp(UpdateTransactionPinGw transactionPinGw) {
        this.transactionPinGw = transactionPinGw;
    }

    @Override
    public TransactionPin updateTransactionPin(TransactionPin transactionPin) {
        return transactionPinGw.update(transactionPin);
    }
}
