package com.gusdev.transfershop.ucimp;

import com.gusdev.transfershop.domain.Transaction;
import com.gusdev.transfershop.exceptions.TransferException;
import com.gusdev.transfershop.exceptions.enums.ErrorCode;
import com.gusdev.transfershop.gateway.ValidateTransactionGw;
import com.gusdev.transfershop.usecase.ValidateTransactionUc;

public class ValidateTransactionImp implements ValidateTransactionUc {
    private ValidateTransactionGw validateTransactionGw;

    public ValidateTransactionImp(ValidateTransactionGw validateTransactionGw) {
        this.validateTransactionGw = validateTransactionGw;
    }

    @Override
    public Boolean validateTransaction(Transaction transaction) throws TransferException {
        if (!validateTransactionGw.validate(transaction)) {
            throw new TransferException(ErrorCode.TR0004.getMessage(), ErrorCode.TR0004.getCode());
        }
        return true;
    }
}
