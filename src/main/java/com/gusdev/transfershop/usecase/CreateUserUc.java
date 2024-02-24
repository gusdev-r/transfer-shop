package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.core.domain.User;
import com.gusdev.transfershop.core.exceptions.EmailException;
import com.gusdev.transfershop.core.exceptions.InternalServerErrorException;
import com.gusdev.transfershop.core.exceptions.TaxNumberException;
import com.gusdev.transfershop.core.exceptions.TransactionPinException;

public interface CreateUserUc {

    void createUser(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException;
}
