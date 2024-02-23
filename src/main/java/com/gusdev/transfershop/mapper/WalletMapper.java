package com.gusdev.transfershop.mapper;

import com.gusdev.transfershop.domain.Wallet;
import com.gusdev.transfershop.entity.TransactionPinEntity;
import com.gusdev.transfershop.entity.UserEntity;
import com.gusdev.transfershop.entity.WalletEntity;

public class WalletMapper {
    public WalletEntity toWalletEntity (Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity) {
        return new WalletEntity(
                wallet.getBalance(),
                userEntity,
                transactionPinEntity,
                wallet.getCreatedAt(),
                wallet.getUpdateAt()
        );
    }
}
