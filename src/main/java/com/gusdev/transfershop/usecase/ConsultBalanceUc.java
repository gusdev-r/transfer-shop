package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUc {

    BigDecimal consult(Wallet wallet);
}
