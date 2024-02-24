package com.gusdev.transfershop.ucimp;

import com.gusdev.transfershop.core.domain.Wallet;
import com.gusdev.transfershop.core.exceptions.NotFoundException;
import com.gusdev.transfershop.core.exceptions.enums.ErrorCode;
import com.gusdev.transfershop.gateway.FindWalletByTaxNumberGw;
import com.gusdev.transfershop.usecase.FindWalletByTaxNumberUc;

public class FindWalletByTaxNumberImp implements FindWalletByTaxNumberUc {
    private FindWalletByTaxNumberGw findWalletByTaxNumberGw;

    public FindWalletByTaxNumberImp(FindWalletByTaxNumberGw findWalletByTaxNumberGw) {
        this.findWalletByTaxNumberGw = findWalletByTaxNumberGw;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws Exception {
        var wallet = findWalletByTaxNumberGw.findTaxNumber(taxNumber);
        if (wallet == null) {
            throw new NotFoundException(ErrorCode.WA0001.getMessage(), ErrorCode.WA0001.getCode());
        }
        return wallet;
    }
}

