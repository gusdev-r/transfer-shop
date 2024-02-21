package com.gusdev.transfershop.gateway;

import com.gusdev.transfershop.domain.Transaction;

public interface TransferGw {
    Boolean transfer(Transaction transaction);
}
