package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.domain.User;
import com.gusdev.transfershop.exceptions.EmailException;
import com.gusdev.transfershop.exceptions.InternalServerErrorException;
import com.gusdev.transfershop.exceptions.TaxNumberException;
import com.gusdev.transfershop.exceptions.TransactionPinException;

public interface CreateUserUc {

    void crateUser(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException;
}
