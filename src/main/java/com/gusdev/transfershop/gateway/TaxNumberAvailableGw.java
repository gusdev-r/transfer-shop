package com.gusdev.transfershop.gateway;

import com.gusdev.transfershop.domain.TransactionPin;

public interface TaxNumberAvailableGw {
    Boolean taxNumberAvailable(String taxNumber);
}
