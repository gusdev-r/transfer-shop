package com.gusdev.transfershop.ucimp;

import com.gusdev.transfershop.core.domain.TransactionPin;
import com.gusdev.transfershop.core.exceptions.PinException;
import com.gusdev.transfershop.core.exceptions.TransferException;
import com.gusdev.transfershop.core.exceptions.enums.ErrorCode;
import com.gusdev.transfershop.gateway.ValidateTransactionPinGw;
import com.gusdev.transfershop.usecase.ValidateTransactionPinUc;
import com.gusdev.transfershop.usecase.UpdateTransactionPinUc;

public class ValidateTransactionPinImp implements ValidateTransactionPinUc {
    private ValidateTransactionPinGw validateTransactionPinGw;
    private UpdateTransactionPinUc updateTransactionPinUc;

    public ValidateTransactionPinImp(ValidateTransactionPinGw validateTransactionPinGw, UpdateTransactionPinUc updateTransactionPinUc) {
        this.validateTransactionPinGw = validateTransactionPinGw;
        this.updateTransactionPinUc = updateTransactionPinUc;
    }

    @Override
    public Boolean validateTransactionPin(TransactionPin transactionPin, String pin) throws TransferException, PinException {
        if (transactionPin.getBlocked()) {
            throw new PinException(ErrorCode.PIN0001.getMessage(), ErrorCode.PIN0001.getCode());
        }
        if (!validateTransactionPinGw.validate(transactionPin, pin)) {
            transactionPin.setAttempt();
            var transactionPinToUpdate = updateTransactionPinUc.updateTransactionPin(transactionPin);
            throw new PinException(ErrorCode.pin0002GetMessage(transactionPinToUpdate.getAttempt()), ErrorCode.PIN0002.getCode());
        }
        if (transactionPin.getAttempt() < 3) {
            transactionPin.restorationAttempt();
            updateTransactionPinUc.updateTransactionPin(transactionPin);
        }
        return true;
    }
}
