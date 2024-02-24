package com.gusdev.transfershop.infra.service;

import com.gusdev.transfershop.gateway.EmailAvailableGw;
import com.gusdev.transfershop.infra.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import static com.gusdev.transfershop.infra.utils.Utility.LOGGER;

@Service
public class EmailAvailableService implements EmailAvailableGw {
    private UserEntityRepository userRepository;

    public EmailAvailableService(UserEntityRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Boolean emailAvailable(String email) {
        //it not works as an exists but verify if it's available
        LOGGER.info("Verification of the ");
        return !userRepository.existsByEmail(email);
    }
}
