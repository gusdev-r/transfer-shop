package com.gusdev.transfershop.ucimp;

import com.gusdev.transfershop.core.domain.Wallet;
import com.gusdev.transfershop.gateway.ConsultBalanceGw;
import com.gusdev.transfershop.usecase.ConsultBalanceUc;
import com.gusdev.transfershop.usecase.FindWalletByTaxNumberUc;

import java.math.BigDecimal;

public class ConsultBalanceImp implements ConsultBalanceUc {
    private FindWalletByTaxNumberUc findWalletByTaxNumberUc;

    public ConsultBalanceImp(FindWalletByTaxNumberUc findWalletByTaxNumberUc) {
        this.findWalletByTaxNumberUc = findWalletByTaxNumberUc;
    }

    @Override
    public BigDecimal consult(String taxNumber) throws Exception{
        return findWalletByTaxNumberUc.findByTaxNumber(taxNumber).getBalance();
    }
}
