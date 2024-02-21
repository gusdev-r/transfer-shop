package com.gusdev.transfershop.gateway;

import com.gusdev.transfershop.domain.Transaction;
import com.gusdev.transfershop.domain.TransactionPin;

public interface TransactionValidateGw {
    Boolean validate(Transaction transaction);
}
