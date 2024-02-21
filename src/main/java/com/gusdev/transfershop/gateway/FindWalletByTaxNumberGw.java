package com.gusdev.transfershop.gateway;

import com.gusdev.transfershop.domain.Wallet;

public interface FindWalletByTaxNumberGw {
    Wallet findTaxNumber(String taxNumber);
}
