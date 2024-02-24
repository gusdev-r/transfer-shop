package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.core.domain.Transaction;
import com.gusdev.transfershop.core.exceptions.TransferException;

public interface CreateTransactionUc {
    Transaction createTransaction(Transaction transaction) throws TransferException;
}
