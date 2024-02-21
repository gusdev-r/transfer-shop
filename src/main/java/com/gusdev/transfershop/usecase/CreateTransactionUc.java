package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.domain.Transaction;
import com.gusdev.transfershop.exceptions.TransferException;

public interface CreateTransactionUc {
    Transaction createTransaction(Transaction transaction) throws TransferException;
}
