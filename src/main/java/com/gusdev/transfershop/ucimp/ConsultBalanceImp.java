package com.gusdev.transfershop.ucimp;

import com.gusdev.transfershop.domain.Wallet;
import com.gusdev.transfershop.gateway.ConsultBalanceGw;
import com.gusdev.transfershop.usecase.ConsultBalanceUc;

import java.math.BigDecimal;

public class ConsultBalanceImp implements ConsultBalanceUc {

    private ConsultBalanceGw consultBalanceGw;

    public ConsultBalanceImp(ConsultBalanceGw consultBalanceGw) {
        this.consultBalanceGw = consultBalanceGw;
    }

    @Override
    public BigDecimal consult(Wallet wallet) {
        return null;
    }
}
