package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.core.domain.Wallet;
import com.gusdev.transfershop.core.exceptions.NotFoundException;

public interface FindWalletByTaxNumberUc {
    Wallet findByTaxNumber(String taxNumber) throws Exception;
}
