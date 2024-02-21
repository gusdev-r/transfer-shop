package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.domain.Transaction;
import com.gusdev.transfershop.domain.TransactionPin;
import com.gusdev.transfershop.exceptions.PinException;
import com.gusdev.transfershop.exceptions.TransferException;

public interface TransactionPinValidateUc {
    Boolean validateTransactionPin(TransactionPin transactionPin) throws TransferException, PinException;
}
