package com.gusdev.transfershop.infra.service;

import com.gusdev.transfershop.core.domain.TransactionPin;
import com.gusdev.transfershop.gateway.UpdateTransactionPinGw;
import com.gusdev.transfershop.infra.mapper.TransactionPinMapper;
import com.gusdev.transfershop.infra.repository.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;

import static com.gusdev.transfershop.infra.utils.Utility.LOGGER;

@Service
public class UpdateTransactionPinService implements UpdateTransactionPinGw {
    private TransactionPinEntityRepository transactionPinRepository;
    private TransactionPinMapper transactionPinMapper;

    public UpdateTransactionPinService(TransactionPinEntityRepository transactionPinRepository, TransactionPinMapper transactionPinMapper) {
        this.transactionPinRepository = transactionPinRepository;
        this.transactionPinMapper = transactionPinMapper;
    }

    @Override
    public TransactionPin update(TransactionPin transactionPin) {
        LOGGER.info("Starting the update of the transction password/pin - UpdateTransactionPinService");
        return transactionPinMapper.transactionPinEntityToTransactionPin(transactionPinRepository.save(transactionPinMapper.
                transactionPinToTransactionPinEntityUpdate(transactionPin)));
    }
}
