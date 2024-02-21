package com.gusdev.transfershop.ucimp;

import com.gusdev.transfershop.gateway.EmailAvailableGw;
import com.gusdev.transfershop.usecase.EmailAvailableUc;

public class EmailAvailableImp implements EmailAvailableUc {
    private EmailAvailableGw emailAvailableGw;

    public EmailAvailableImp(EmailAvailableGw emailAvailableGw) {
        this.emailAvailableGw = emailAvailableGw;
    }

    @Override
    public Boolean emailAvailable(String email) {
        return null;
    }
}
