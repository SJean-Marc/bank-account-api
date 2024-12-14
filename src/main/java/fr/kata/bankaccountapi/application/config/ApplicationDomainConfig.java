package fr.kata.bankaccountapi.application.config;

import fr.kata.bankaccountapi.domain.DepositDollarsToAccount;
import fr.kata.bankaccountapi.domain.WithdrawDollarsFromAccount;
import fr.kata.bankaccountapi.domain.api.DepositToAccount;
import fr.kata.bankaccountapi.domain.api.WithdrawFromAccount;
import fr.kata.bankaccountapi.domain.spi.AccountLoader;
import fr.kata.bankaccountapi.domain.spi.AccountTransactionSaver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationDomainConfig {

    @Bean
    public DepositToAccount depositToAccount(AccountTransactionSaver accountTransactionSaver) {
        return new DepositDollarsToAccount(accountTransactionSaver);
    }

    @Bean
    public WithdrawFromAccount withdrawFromAccount(AccountLoader accountLoader,
                                                   AccountTransactionSaver accountTransactionSaver) {
        return new WithdrawDollarsFromAccount(accountLoader, accountTransactionSaver);
    }
}
