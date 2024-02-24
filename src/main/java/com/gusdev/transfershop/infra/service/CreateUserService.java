package com.gusdev.transfershop.infra.service;

import com.gusdev.transfershop.core.domain.User;
import com.gusdev.transfershop.core.domain.Wallet;
import com.gusdev.transfershop.gateway.CreateUserGw;
import com.gusdev.transfershop.infra.mapper.TransactionPinMapper;
import com.gusdev.transfershop.infra.mapper.UserMapper;
import com.gusdev.transfershop.infra.mapper.WalletMapper;
import com.gusdev.transfershop.infra.repository.TransactionPinEntityRepository;
import com.gusdev.transfershop.infra.repository.UserEntityRepository;
import com.gusdev.transfershop.infra.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;

import static com.gusdev.transfershop.infra.utils.Utility.LOGGER;

@Service
public class CreateUserService implements CreateUserGw {
    private UserEntityRepository userRepository;
    private WalletEntityRepository walletRepository;
    private TransactionPinEntityRepository transactionPinRepository;
    private UserMapper userMapper;
    private TransactionPinMapper transactionPinMapper;
    private WalletMapper walletMapper;

    public CreateUserService(UserEntityRepository userRepository, WalletEntityRepository walletRepository,
                             TransactionPinEntityRepository transactionPinRepository, UserMapper userMapper, TransactionPinMapper
                              transactionPinMapper, WalletMapper walletMapper) {
        this.userRepository = userRepository;
        this.walletRepository = walletRepository;
        this.transactionPinRepository = transactionPinRepository;
        this.userMapper = userMapper;
        this.transactionPinMapper = transactionPinMapper;
        this.walletMapper = walletMapper;
    }

    @Override
    public Boolean create(User user, Wallet wallet) {
        try {
            LOGGER.info("Request received to create a new user.");
            var userSaved = userRepository.save(userMapper.userEntityToUser(user));
            var transactionPinSaved = transactionPinRepository.save(transactionPinMapper.transactionPinToTransactionPinEntity(wallet.getTransactionPin()));
            walletRepository.save(walletMapper.toWalletEntity(wallet, userSaved, transactionPinSaved));
            LOGGER.info("User created successful.");
            return true;
        } catch (Exception e) {
            LOGGER.error("The creation of the user wasn't successful.");
            return false;
        }
    }
}
