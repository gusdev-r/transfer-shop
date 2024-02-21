package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.domain.Wallet;
import com.gusdev.transfershop.exceptions.NotFoundException;

public interface FindWalletByTaxNumberUc {
    Wallet findByTaxNumber(String taxNumber) throws NotFoundException;
}
