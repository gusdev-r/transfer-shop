package com.gusdev.transfershop.ucimp;

import com.gusdev.transfershop.exceptions.AuthenticateException;
import com.gusdev.transfershop.exceptions.enums.ErrorCode;
import com.gusdev.transfershop.gateway.UserAuthenticateGw;
import com.gusdev.transfershop.usecase.UserAuthenticateUc;

public class UserAuthenticateImp implements UserAuthenticateUc {
    private UserAuthenticateGw authenticateGw;

    public UserAuthenticateImp(UserAuthenticateGw authenticateGw) {
        this.authenticateGw = authenticateGw;
    }

    @Override
    public Boolean authenticateUser(String username, String password) throws AuthenticateException {
        if (authenticateGw.validate(username, password)) {
            throw new AuthenticateException(ErrorCode.ATH0001.getMessage(), ErrorCode.ATH0001.getCode());
        }
        return true;
    }
}
