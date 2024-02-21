package com.gusdev.transfershop.ucimp;

import com.gusdev.transfershop.domain.Transaction;
import com.gusdev.transfershop.exceptions.TransferException;
import com.gusdev.transfershop.exceptions.enums.ErrorCode;
import com.gusdev.transfershop.gateway.TransactionValidateGw;
import com.gusdev.transfershop.usecase.TransactionValidateUc;

public class TransactionValidateImp implements TransactionValidateUc {
    private TransactionValidateGw transactionValidateGw;

    public TransactionValidateImp(TransactionValidateGw transactionValidateGw) {
        this.transactionValidateGw = transactionValidateGw;
    }

    @Override
    public Boolean transactionValidate(Transaction transaction) throws TransferException {
        if (!transactionValidateGw.validate(transaction)) {
            throw new TransferException(ErrorCode.TR0004.getMessage(), ErrorCode.TR0004.getCode());
        }
        return true;
    }
}
