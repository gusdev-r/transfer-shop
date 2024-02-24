package com.gusdev.transfershop.gateway;

import com.gusdev.transfershop.core.domain.Wallet;

public interface FindWalletByTaxNumberGw {
    Wallet findTaxNumber(String taxNumber) throws Exception;
}
