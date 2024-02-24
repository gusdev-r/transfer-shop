package com.gusdev.transfershop.ucimp;

import com.gusdev.transfershop.core.domain.Transaction;
import com.gusdev.transfershop.core.domain.Wallet;
import com.gusdev.transfershop.core.exceptions.*;
import com.gusdev.transfershop.core.exceptions.enums.ErrorCode;
import com.gusdev.transfershop.gateway.TransferGw;
import com.gusdev.transfershop.usecase.*;

import java.math.BigDecimal;

public class TransferImp implements TransferUc {
    private FindWalletByTaxNumberUc findWalletByTaxNumberUc;
    private ValidateTransactionPinUc validateTransactionPinUc;
    private ValidateTransactionUc validateTransactionUc;
    private CreateTransactionUc createTransactionUc;
    private UserNotificationUc userNotificationUc;
    private TransferGw transferGw;

    public TransferImp(FindWalletByTaxNumberUc findWalletByTaxNumberUc, ValidateTransactionPinUc validateTransactionPinUc,
                       ValidateTransactionUc validateTransactionUc, CreateTransactionUc createTransactionUc, UserNotificationUc userNotificationUc,
                       TransferGw transferGw) {
        this.findWalletByTaxNumberUc = findWalletByTaxNumberUc;
        this.validateTransactionPinUc = validateTransactionPinUc;
        this.validateTransactionUc = validateTransactionUc;
        this.createTransactionUc = createTransactionUc;
        this.userNotificationUc = userNotificationUc;
        this.transferGw = transferGw;
    }

    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) throws Exception {
        Wallet transferFrom = findWalletByTaxNumberUc.findByTaxNumber(fromTaxNumber);
        Wallet transferTo = findWalletByTaxNumberUc.findByTaxNumber(toTaxNumber);
        validateTransactionPinUc.validateTransactionPin(transferFrom.getTransactionPin(), pin);

        transferFrom.sendTransfer(value);
        transferTo.receiveTransfer(value);
        var transaction = createTransactionUc.createTransaction(new Transaction(transferFrom, transferTo, value));
        validateTransactionUc.validateTransaction(transaction);

        //if (!transferGw.transfer(transaction)) throw new InternalServerErrorException(ErrorCode.TR0003.getMessage(), ErrorCode.TR0003.getCode());
        if (!transferGw.transfer(transaction)) {
            throw new InternalServerErrorException(ErrorCode.TR0003.getMessage(), ErrorCode.TR0003.getCode());
        }
        if (!userNotificationUc.notifyUser(transaction, transferFrom.getUser().getEmail())) {
             throw new NotificationException(ErrorCode.TR0001.getMessage(), ErrorCode.TR0002.getCode());
        }
        return true;
    }
}
