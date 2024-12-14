package fr.kata.bankaccountapi.application.config;

import fr.kata.bankaccountapi.domain.DepositDollarsToAccount;
import fr.kata.bankaccountapi.domain.api.DepositToAccount;
import fr.kata.bankaccountapi.domain.spi.DepositSaver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationDomainConfig {

    @Bean
    public DepositToAccount depositToAccount(DepositSaver depositSaver) {
        return new DepositDollarsToAccount(depositSaver);
    }
}
