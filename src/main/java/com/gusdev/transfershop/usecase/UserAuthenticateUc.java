package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.exceptions.AuthenticateException;

public interface UserAuthenticateUc {
    Boolean authenticateUser(String username, String password) throws AuthenticateException;
}
