package com.gusdev.transfershop.gateway;

import com.gusdev.transfershop.domain.Transaction;

public interface CreateTransactionGw {
    Transaction create(Transaction transaction);
}
