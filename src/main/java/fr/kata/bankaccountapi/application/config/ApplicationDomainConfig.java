package fr.kata.bankaccountapi.application.config;

import fr.kata.bankaccountapi.domain.AccountStatementsHistoryInDollar;
import fr.kata.bankaccountapi.domain.DepositDollarsToAccount;
import fr.kata.bankaccountapi.domain.WithdrawDollarsFromAccount;
import fr.kata.bankaccountapi.domain.api.AccountStatementsHistory;
import fr.kata.bankaccountapi.domain.api.DepositToAccount;
import fr.kata.bankaccountapi.domain.api.WithdrawFromAccount;
import fr.kata.bankaccountapi.domain.spi.AccountLoader;
import fr.kata.bankaccountapi.domain.spi.AccountSaver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationDomainConfig {

    @Bean
    public DepositToAccount depositToAccount(AccountSaver accountSaver) {
        return new DepositDollarsToAccount(accountSaver);
    }

    @Bean
    public WithdrawFromAccount withdrawFromAccount(AccountLoader accountLoader,
                                                   AccountSaver accountSaver) {
        return new WithdrawDollarsFromAccount(accountLoader, accountSaver);
    }

    @Bean
    public AccountStatementsHistory accountStatementsHistory(AccountLoader accountLoader) {
        return new AccountStatementsHistoryInDollar(accountLoader);
    }
}
