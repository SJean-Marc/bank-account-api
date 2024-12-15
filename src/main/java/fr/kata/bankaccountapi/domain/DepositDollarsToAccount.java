package fr.kata.bankaccountapi.domain;

import fr.kata.bankaccountapi.domain.api.DepositToAccount;
import fr.kata.bankaccountapi.domain.spi.AccountSaver;

public class DepositDollarsToAccount implements DepositToAccount {
    private final AccountSaver accountSaver;

    public DepositDollarsToAccount(AccountSaver accountSaver) {
        this.accountSaver = accountSaver;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            accountSaver.save(amount);
        }
    }
}
