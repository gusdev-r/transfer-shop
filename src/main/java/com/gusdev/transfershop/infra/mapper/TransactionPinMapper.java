package com.gusdev.transfershop.infra.mapper;

import com.gusdev.transfershop.core.domain.TransactionPin;
import com.gusdev.transfershop.infra.entity.TransactionPinEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionPinMapper {
    public TransactionPinEntity transactionPinToTransactionPinEntity(TransactionPin transactionPin) {
        return new TransactionPinEntity(
          transactionPin.getPin(),
          transactionPin.getAttempt(),
          transactionPin.getBlocked(),
          transactionPin.getCreatedAt(),
          transactionPin.getUpdateAt()
        );
    }
    public TransactionPinEntity transactionPinToTransactionPinEntityUpdate(TransactionPin transactionPin){
        return new TransactionPinEntity(
                transactionPin.getId(),
                transactionPin.getPin(),
                transactionPin.getAttempt(),
                transactionPin.getBlocked(),
                transactionPin.getCreatedAt(),
                transactionPin.getUpdateAt()
        );
    }
    public TransactionPin transactionPinEntityToTransactionPin(TransactionPinEntity transactionPinEntity) {
        return new TransactionPin(
                transactionPinEntity.getId(),
                transactionPinEntity.getPin(),
                transactionPinEntity.getAttempt(),
                transactionPinEntity.getBlocked(),
                transactionPinEntity.getCreatedAt(),
                transactionPinEntity.getUpdatedAt()
        );
    }
}
