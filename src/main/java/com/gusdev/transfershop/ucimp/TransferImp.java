package com.gusdev.transfershop.ucimp;

import com.gusdev.transfershop.domain.Transaction;
import com.gusdev.transfershop.domain.Wallet;
import com.gusdev.transfershop.exceptions.*;
import com.gusdev.transfershop.exceptions.enums.ErrorCode;
import com.gusdev.transfershop.gateway.TransferGw;
import com.gusdev.transfershop.usecase.*;

import java.math.BigDecimal;

public class TransferImp implements TransferUc {
    private FindWalletByTaxNumberUc findWalletByTaxNumberUc;
    private TransactionPinValidateUc transactionPinValidateUc;
    private TransactionValidateUc transactionValidateUc;
    private CreateTransactionUc createTransactionUc;
    private UserNotificationUc userNotificationUc;
    private TransferGw transferGw;

    public TransferImp(FindWalletByTaxNumberUc findWalletByTaxNumberUc, TransactionPinValidateUc transactionPinValidateUc,
                       TransactionValidateUc transactionValidateUc, CreateTransactionUc createTransactionUc, UserNotificationUc userNotificationUc,
                       TransferGw transferGw) {
        this.findWalletByTaxNumberUc = findWalletByTaxNumberUc;
        this.transactionPinValidateUc = transactionPinValidateUc;
        this.transactionValidateUc = transactionValidateUc;
        this.createTransactionUc = createTransactionUc;
        this.userNotificationUc = userNotificationUc;
        this.transferGw = transferGw;
    }

    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) throws InternalServerErrorException, NotFoundException, TransferException, NotificationException, PinException {
        Wallet transferFrom = findWalletByTaxNumberUc.findByTaxNumber(fromTaxNumber);
        Wallet transferTo = findWalletByTaxNumberUc.findByTaxNumber(toTaxNumber);
        transactionPinValidateUc.validateTransactionPin(transferFrom.getTransactionPin());

        transferFrom.sendTransfer(value);
        transferTo.receiveTransfer(value);
        var transaction = createTransactionUc.createTransaction(new Transaction(transferFrom, transferTo, value));
        transactionValidateUc.transactionValidate(transaction);

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