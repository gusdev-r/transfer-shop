package com.gusdev.transfershop.infra.service;

import com.gusdev.transfershop.core.domain.Wallet;
import com.gusdev.transfershop.gateway.FindWalletByTaxNumberGw;
import com.gusdev.transfershop.infra.mapper.WalletMapper;
import com.gusdev.transfershop.infra.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;

import static com.gusdev.transfershop.infra.utils.Utility.LOGGER;

@Service
public class FindWalletByTaxNumberService implements FindWalletByTaxNumberGw {
    private WalletEntityRepository walletRepository;
    private WalletMapper walletMapper;

    public FindWalletByTaxNumberService(WalletEntityRepository walletRepository, WalletMapper walletMapper) {
        this.walletRepository = walletRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Wallet findTaxNumber(String taxNumber) throws Exception {
        LOGGER.info("Starting the search at the Wallet - FindWalletByTaxNumberService");
        return walletMapper.walletEntityToWallet(walletRepository.findByUserEntityTaxNumber(taxNumber));
    }
}
