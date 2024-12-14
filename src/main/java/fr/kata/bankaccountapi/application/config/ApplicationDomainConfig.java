package fr.kata.bankaccountapi.application.config;

import fr.kata.bankaccountapi.domain.DepositDollarsToAccount;
import fr.kata.bankaccountapi.domain.WithdrawDollarsFromAccount;
import fr.kata.bankaccountapi.domain.api.DepositToAccount;
import fr.kata.bankaccountapi.domain.api.WithdrawFromAccount;
import fr.kata.bankaccountapi.domain.spi.AccountLoader;
import fr.kata.bankaccountapi.domain.spi.DepositSaver;
import fr.kata.bankaccountapi.domain.spi.WithdrawSaver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationDomainConfig {

    @Bean
    public DepositToAccount depositToAccount(DepositSaver depositSaver) {
        return new DepositDollarsToAccount(depositSaver);
    }


    @Bean
    public WithdrawFromAccount withdrawFromAccount(AccountLoader accountLoader,
                                                   WithdrawSaver withdrawSaver) {
        return new WithdrawDollarsFromAccount(accountLoader, withdrawSaver);
    }
}
