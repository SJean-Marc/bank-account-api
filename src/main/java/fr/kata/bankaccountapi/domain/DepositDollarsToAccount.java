package fr.kata.bankaccountapi.domain;

import fr.kata.bankaccountapi.domain.api.DepositToAccount;
import fr.kata.bankaccountapi.domain.spi.DepositSaver;

public class DepositDollarsToAccount implements DepositToAccount {
    private final DepositSaver depositSaver;

    public DepositDollarsToAccount(DepositSaver depositSaver) {
        this.depositSaver = depositSaver;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            depositSaver.save(amount);
        }
    }
}
