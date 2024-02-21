package com.gusdev.transfershop.ucimp;

import com.gusdev.transfershop.domain.Transaction;
import com.gusdev.transfershop.exceptions.TransferException;
import com.gusdev.transfershop.gateway.CreateTransactionGw;
import com.gusdev.transfershop.usecase.CreateTransactionUc;

public class CreateTransactionImp implements CreateTransactionUc {
    private CreateTransactionGw createTransactionGw;

    public CreateTransactionImp(CreateTransactionGw createTransactionGw) {
        this.createTransactionGw = createTransactionGw;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) throws TransferException {
        return null;
    }
}
