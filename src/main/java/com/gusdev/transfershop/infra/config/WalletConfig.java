package com.gusdev.transfershop.infra.config;

import com.gusdev.transfershop.gateway.*;
import com.gusdev.transfershop.ucimp.*;
import com.gusdev.transfershop.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WalletConfig {
    @Bean
    public FindWalletByTaxNumberUc findWalletByTaxNumberUc(FindWalletByTaxNumberGw findWalletByTaxNumberGw) {
        return new FindWalletByTaxNumberImp(findWalletByTaxNumberGw);
    }

    @Bean
    public ConsultBalanceUc consultBalanceUc(FindWalletByTaxNumberUc findWalletByTaxNumberUc) {
        return new ConsultBalanceImp(findWalletByTaxNumberUc);
    }

    @Bean
    public ValidateTransactionUc transactionValidateUc(ValidateTransactionGw validateTransactionGw) {
        return new ValidateTransactionImp(validateTransactionGw);
    }

    @Bean
    public CreateTransactionUc createTransactionUc(CreateTransactionGw createTransactionGw) {
        return new CreateTransactionImp(createTransactionGw);
    }

    @Bean
    public UserNotificationUc userNotificationUc(UserNotificationGw userNotificationGw) {
        return new UserNotificationImp(userNotificationGw);
    }

    @Bean
    public UpdateTransactionPinUc updateTransactionPinUc(UpdateTransactionPinGw updateTransactionPinGw) {
        return new UpdateTransactionImp(updateTransactionPinGw);
    }

    @Bean
    public ValidateTransactionPinUc transactionPinValidateUc(ValidateTransactionPinGw validateTransactionPinGw, UpdateTransactionPinUc updateTransactionPinUc) {
        return new ValidateTransactionPinImp(validateTransactionPinGw, updateTransactionPinUc);
    }

    @Bean
    public TransferUc transferUc(FindWalletByTaxNumberUc findWalletByTaxNumberUc, ValidateTransactionUc validateTransactionUc,
                                 CreateTransactionUc createTransactionUc, TransferGw transferGw, UserNotificationUc userNotificationUc,
                                 ValidateTransactionPinUc validateTransactionPinUc) {
        return new TransferImp(findWalletByTaxNumberUc, validateTransactionPinUc, validateTransactionUc, createTransactionUc, userNotificationUc, transferGw);
    }
}
