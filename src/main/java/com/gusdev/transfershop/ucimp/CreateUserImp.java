package com.gusdev.transfershop.ucimp;

import com.gusdev.transfershop.core.domain.TransactionPin;
import com.gusdev.transfershop.core.domain.User;
import com.gusdev.transfershop.core.domain.Wallet;
import com.gusdev.transfershop.core.exceptions.EmailException;
import com.gusdev.transfershop.core.exceptions.InternalServerErrorException;
import com.gusdev.transfershop.core.exceptions.TaxNumberException;
import com.gusdev.transfershop.core.exceptions.TransactionPinException;
import com.gusdev.transfershop.core.exceptions.enums.ErrorCode;
import com.gusdev.transfershop.gateway.CreateUserGw;
import com.gusdev.transfershop.gateway.EmailAvailableGw;
import com.gusdev.transfershop.gateway.TaxNumberAvailableGw;
import com.gusdev.transfershop.usecase.CreateUserUc;

import java.math.BigDecimal;

public class CreateUserImp implements CreateUserUc {
    private CreateUserGw createUserGw;
    private TaxNumberAvailableGw taxNumberAvailableGw;
    private EmailAvailableGw emailAvailableGw;

    public CreateUserImp(TaxNumberAvailableGw taxNumberAvailableGw, EmailAvailableGw emailAvailableGw, CreateUserGw createUserGw) {
        this.taxNumberAvailableGw = taxNumberAvailableGw;
        this.emailAvailableGw = emailAvailableGw;
        this.createUserGw = createUserGw;
    }
    @Override
    public void createUser(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException {
        if (!taxNumberAvailableGw.taxNumberAvailable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCode.ON0002.getMessage(), ErrorCode.ON0002.getCode());
        }
        if (!emailAvailableGw.emailAvailable(user.getEmail())) {
            throw new EmailException(ErrorCode.ON0003.getMessage(), ErrorCode.ON0003.getCode());
        }
        if (!createUserGw.create(user, new Wallet(new TransactionPin(pin), BigDecimal.ZERO, user))) {
            throw new InternalServerErrorException(ErrorCode.ON0004.getMessage(), ErrorCode.ON0004.getCode());
        }
    }
}
