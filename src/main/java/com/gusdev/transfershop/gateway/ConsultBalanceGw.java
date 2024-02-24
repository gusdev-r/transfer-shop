package com.gusdev.transfershop.gateway;

import com.gusdev.transfershop.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceGw {
    BigDecimal consult(Wallet wallet);
}
