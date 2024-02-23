package com.gusdev.transfershop.gateway;

import com.gusdev.transfershop.domain.Transaction;

public interface ValidateTransactionGw {
    Boolean validate(Transaction transaction);
}
