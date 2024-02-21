package com.gusdev.transfershop.usecase;

import com.gusdev.transfershop.exceptions.*;

import java.math.BigDecimal;

public interface TransferUc {
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin)
        throws InternalServerErrorException, NotFoundException, TransferException, NotificationException, PinException;
}
