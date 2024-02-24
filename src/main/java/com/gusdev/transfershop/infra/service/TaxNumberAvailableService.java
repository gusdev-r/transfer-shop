package com.gusdev.transfershop.infra.service;

import com.gusdev.transfershop.gateway.TaxNumberAvailableGw;
import com.gusdev.transfershop.infra.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import static com.gusdev.transfershop.infra.utils.Utility.LOGGER;

@Service
public class TaxNumberAvailableService implements TaxNumberAvailableGw {
    private UserEntityRepository userRepository;
    public TaxNumberAvailableService(UserEntityRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        LOGGER.info("Starting the verification if the TaxNumber is available.");
        return userRepository.existsByTaxNumber(taxNumber);
    }
}
