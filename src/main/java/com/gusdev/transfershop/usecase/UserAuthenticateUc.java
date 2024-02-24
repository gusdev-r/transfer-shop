package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.core.exceptions.AuthenticateException;

public interface UserAuthenticateUc {
    Boolean authenticateUser(String username, String password) throws AuthenticateException;
}
