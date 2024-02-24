package com.gusdev.transfershop.infra.mapper;

import com.gusdev.transfershop.core.domain.Wallet;
import com.gusdev.transfershop.infra.entity.TransactionPinEntity;
import com.gusdev.transfershop.infra.entity.UserEntity;
import com.gusdev.transfershop.infra.entity.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {
    private TransactionPinMapper transactionPinMapper;
    private UserMapper userMapper;

    public WalletMapper(TransactionPinMapper transactionPinMapper, UserMapper userMapper) {
        this.transactionPinMapper = transactionPinMapper;
        this.userMapper = userMapper;
    }

    public WalletEntity toWalletEntity (Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity) {
        return new WalletEntity(
                wallet.getBalance(),
                userEntity,
                transactionPinEntity,
                wallet.getCreatedAt(),
                wallet.getUpdateAt()
        );
    }
    public WalletEntity toWalletEntity(Wallet wallet) {
        return new WalletEntity(
                wallet.getBalance(),
                userMapper.userEntityToUser(wallet.getUser()),
                transactionPinMapper.transactionPinToTransactionPinEntity(wallet.getTransactionPin()),
                wallet.getCreatedAt(),
                wallet.getUpdateAt()
        );
    }

    public WalletEntity walletToWalletEntityUpdate(Wallet wallet) {
        return new WalletEntity(
                wallet.getId(),
                wallet.getBalance(),
                userMapper.userEntityToUser(wallet.getUser()),
                transactionPinMapper.transactionPinToTransactionPinEntity(wallet.getTransactionPin()),
                wallet.getCreatedAt(),
                wallet.getUpdateAt()
        );
    }

    public Wallet walletEntityToWallet(WalletEntity walletEntity) throws Exception {
        if (walletEntity == null){
            return null;
        }
        return new Wallet(
                walletEntity.getId(),
                transactionPinMapper.transactionPinEntityToTransactionPin(walletEntity.getTransactionPinEntity()),
                walletEntity.getBalance(),
                userMapper.userEntityToUser(walletEntity.getUserEntity()),
                walletEntity.getCreatedAt(),
                walletEntity.getUpdatedAt()
        );
    }
}
