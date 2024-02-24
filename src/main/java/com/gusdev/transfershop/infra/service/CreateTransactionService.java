package com.gusdev.transfershop.infra.service;

import com.gusdev.transfershop.core.domain.Transaction;
import com.gusdev.transfershop.gateway.CreateTransactionGw;
import com.gusdev.transfershop.infra.mapper.TransactionMapper;
import com.gusdev.transfershop.infra.repository.TransactionEntityRepository;
import org.springframework.stereotype.Service;

import static com.gusdev.transfershop.infra.utils.Utility.LOGGER;

@Service
public class CreateTransactionService implements CreateTransactionGw {
    private TransactionEntityRepository transactionEntityRepository;
    private TransactionMapper transactionMapper;

    public CreateTransactionService(TransactionEntityRepository transactionEntityRepository, TransactionMapper transactionMapper) {
        this.transactionEntityRepository = transactionEntityRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public Transaction create(Transaction transaction) {
        try {
            LOGGER.info("Begin of the creation of the transaction - CreateTransactionService");
            var transactionEntity = transactionMapper.transactionToTransactionEntityCreate(transaction);
            return transactionMapper.transactionEntityToTransaction(transactionEntityRepository.save(transactionEntity));
        } catch (Exception e) {
            LOGGER.info("There was an error while trying to create the user - CreateTransactionService");
            return null;
        }
    }
}
