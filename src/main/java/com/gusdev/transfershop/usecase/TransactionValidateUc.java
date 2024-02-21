package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.domain.Transaction;
import com.gusdev.transfershop.exceptions.TransferException;

public interface TransactionValidateUc {
    Boolean transactionValidate(Transaction transaction) throws TransferException;

}
