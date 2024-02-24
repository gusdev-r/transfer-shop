package com.gusdev.transfershop.gateway;

import com.gusdev.transfershop.core.domain.Transaction;

public interface ValidateTransactionGw {
    Boolean validate(Transaction transaction);
}
