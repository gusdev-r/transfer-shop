package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.domain.Transaction;
import com.gusdev.transfershop.exceptions.TransferException;

public interface ValidateTransactionUc {
    Boolean validateTransaction(Transaction transaction) throws TransferException;

}
