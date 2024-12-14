package fr.kata.bankaccountapi.infrastructure.config;

import fr.kata.bankaccountapi.domain.spi.DepositSaver;
import fr.kata.bankaccountapi.infrastructure.DatabaseDepositSaver;
import fr.kata.bankaccountapi.infrastructure.repository.AccountStatementRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainInfrastructureConfig {
    @Bean
    public DepositSaver depositSaver(AccountStatementRepository accountStatementRepository) {
        return new DatabaseDepositSaver(accountStatementRepository);
    }

}
