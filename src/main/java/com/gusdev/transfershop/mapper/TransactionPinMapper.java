package com.gusdev.transfershop.mapper;

import com.gusdev.transfershop.domain.TransactionPin;
import com.gusdev.transfershop.entity.TransactionEntity;
import com.gusdev.transfershop.entity.TransactionPinEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionPinMapper {
    public TransactionPinEntity toTransactionPinEntity(TransactionPin transactionPin) {
        return new TransactionPinEntity(
          transactionPin.getPin(),
          transactionPin.getAttempt(),
          transactionPin.getBlocked(),
          transactionPin.getCreatedAt(),
          transactionPin.getUpdateAt()
        );
    }

}
