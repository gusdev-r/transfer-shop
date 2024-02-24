package com.gusdev.transfershop.infra.service;

import com.gusdev.transfershop.core.domain.Transaction;
import com.gusdev.transfershop.gateway.TransferGw;
import com.gusdev.transfershop.infra.mapper.TransactionMapper;
import com.gusdev.transfershop.infra.mapper.WalletMapper;
import com.gusdev.transfershop.infra.repository.TransactionEntityRepository;
import com.gusdev.transfershop.infra.repository.WalletEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import static com.gusdev.transfershop.infra.utils.Utility.LOGGER;

@Service
public class TransferService implements TransferGw {
    private WalletEntityRepository walletRepository;
    private WalletMapper walletMapper;
    private TransactionEntityRepository transactionRepository;
    private TransactionMapper transactionMapper;

    public TransferService(WalletEntityRepository walletRepository, WalletMapper walletMapper, TransactionEntityRepository transactionRepository, TransactionMapper transactionMapper) {
        this.walletRepository = walletRepository;
        this.walletMapper = walletMapper;
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    @Transactional
    public Boolean transfer(Transaction transaction) {
        try {
            LOGGER.info("Starting the transfer - TransferService");
            walletRepository.save(walletMapper.walletToWalletEntityUpdate(transaction.getFromWallet()));
            walletRepository.save(walletMapper.walletToWalletEntityUpdate(transaction.getToWallet()));
            transactionRepository.save(transactionMapper.transactionToTransactionEntityConclude(transaction));
            LOGGER.info("Concluding the transfer - TransferService");
            return true;
        } catch (Exception e) {
            transactionRepository.save(transactionMapper.transactionToTransactionEntityCanceled(transaction));
            LOGGER.info("Transfer was canceled - TransferService");
            return false;
        }
    }
}
