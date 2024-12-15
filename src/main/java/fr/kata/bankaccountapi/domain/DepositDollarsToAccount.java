package fr.kata.bankaccountapi.domain;

import fr.kata.bankaccountapi.domain.api.DepositToAccount;
import fr.kata.bankaccountapi.domain.spi.AccountTransactionSaver;

public class DepositDollarsToAccount implements DepositToAccount {
    private final AccountTransactionSaver accountTransactionSaver;

    public DepositDollarsToAccount(AccountTransactionSaver accountTransactionSaver) {
        this.accountTransactionSaver = accountTransactionSaver;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            accountTransactionSaver.save(amount);
        }
    }
}
