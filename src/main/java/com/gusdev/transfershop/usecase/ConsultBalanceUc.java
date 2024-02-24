package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUc {

    BigDecimal consult(String taxNumber) throws Exception;
}
