package com.gusdev.transfershop.infra.config;

import com.gusdev.transfershop.gateway.CreateUserGw;
import com.gusdev.transfershop.gateway.EmailAvailableGw;
import com.gusdev.transfershop.gateway.TaxNumberAvailableGw;
import com.gusdev.transfershop.ucimp.CreateUserImp;
import com.gusdev.transfershop.ucimp.EmailAvailableImp;
import com.gusdev.transfershop.ucimp.TaxNumberAvailableImp;
import com.gusdev.transfershop.usecase.CreateUserUc;
import com.gusdev.transfershop.usecase.EmailAvailableUc;
import com.gusdev.transfershop.usecase.TaxNumberAvailableUc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public TaxNumberAvailableUc taxNumberAvailableUc(TaxNumberAvailableGw taxNumberAvailableGw) {
        return new TaxNumberAvailableImp(taxNumberAvailableGw);
    }
    @Bean
    public EmailAvailableUc emailAvailableUc(EmailAvailableGw emailAvailableGw) {
        return new EmailAvailableImp(emailAvailableGw);
    }
    @Bean
    public CreateUserUc createUserUc(TaxNumberAvailableGw taxNumberAvailableGw, EmailAvailableGw emailAvailableGw,
                                     CreateUserGw createUserGw) {
        return new CreateUserImp(taxNumberAvailableGw, emailAvailableGw, createUserGw);
    }
}
