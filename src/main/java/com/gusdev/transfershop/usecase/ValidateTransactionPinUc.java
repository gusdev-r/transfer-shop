package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.core.domain.TransactionPin;
import com.gusdev.transfershop.core.exceptions.PinException;
import com.gusdev.transfershop.core.exceptions.TransferException;

public interface ValidateTransactionPinUc {
    Boolean validateTransactionPin(TransactionPin transactionPin, String pin) throws TransferException, PinException;
}
