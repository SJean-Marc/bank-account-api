package fr.kata.bankaccountapi.infrastructure.config;

import fr.kata.bankaccountapi.domain.spi.AccountTransactionSaver;
import fr.kata.bankaccountapi.infrastructure.DatabaseAccountTransactionSaver;
import fr.kata.bankaccountapi.infrastructure.repository.AccountStatementRepository;
import fr.kata.bankaccountapi.infrastructure.service.CurrentDateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainInfrastructureConfig {
    @Bean
    public AccountTransactionSaver accountTransactionSaver(
        AccountStatementRepository accountStatementRepository,
        CurrentDateService currentDateService) {
        return new DatabaseAccountTransactionSaver(accountStatementRepository, currentDateService);
    }

}
