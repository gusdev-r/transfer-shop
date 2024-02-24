package com.gusdev.transfershop.infra.mapper;

import com.gusdev.transfershop.core.domain.Transaction;
import com.gusdev.transfershop.core.domain.enums.TransactionStatus;
import com.gusdev.transfershop.infra.entity.TransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    private WalletMapper walletMapper;

    public TransactionMapper(WalletMapper walletMapper) {
        this.walletMapper = walletMapper;
    }
    public TransactionEntity transactionToTransactionEntity(Transaction transaction) {
        return new TransactionEntity(
                walletMapper.toWalletEntity(transaction.getToWallet()),
                walletMapper.toWalletEntity(transaction.getFromWallet()),
                transaction.getValue(),
                transaction.getStatus(),
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
                );
    }
    public TransactionEntity transactionToTransactionEntityCreate(Transaction transaction) {
        return new TransactionEntity(
                walletMapper.walletToWalletEntityUpdate(transaction.getFromWallet()),
                walletMapper.walletToWalletEntityUpdate(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatus.CREATED,
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

    public Transaction transactionEntityToTransaction(TransactionEntity transactionEntity) throws Exception {
        return new Transaction(
                transactionEntity.getId(),
                walletMapper.walletEntityToWallet(transactionEntity.getFromWallet()),
                walletMapper.walletEntityToWallet(transactionEntity.getToWallet()),
                transactionEntity.getValue(),
                transactionEntity.getStatus(),
                transactionEntity.getCreatedAt(),
                transactionEntity.getUpdatedAt()
        );
    }

    public TransactionEntity transactionToTransactionEntityConclude(Transaction transaction) {
        return new TransactionEntity(
                transaction.getId(),
                walletMapper.walletToWalletEntityUpdate(transaction.getFromWallet()),
                walletMapper.walletToWalletEntityUpdate(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatus.SUCCESSFULLY,
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

    public TransactionEntity transactionToTransactionEntityCanceled(Transaction transaction) {
        return new TransactionEntity(
                transaction.getId(),
                walletMapper.walletToWalletEntityUpdate(transaction.getFromWallet()),
                walletMapper.walletToWalletEntityUpdate(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatus.CANCELED,
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }
}
