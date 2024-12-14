package fr.kata.bankaccountapi.domain;

import fr.kata.bankaccountapi.domain.api.WithdrawFromAccount;
import fr.kata.bankaccountapi.domain.error.MinimumOneDollarWithdrawalException;
import fr.kata.bankaccountapi.domain.error.NoFundsException;
import fr.kata.bankaccountapi.domain.spi.AccountLoader;
import fr.kata.bankaccountapi.domain.spi.WithdrawSaver;

public class WithdrawDollarsFromAccount implements WithdrawFromAccount {
    private final AccountLoader accountLoader;
    private final WithdrawSaver withdrawSaver;

    public WithdrawDollarsFromAccount(AccountLoader accountLoader,
                                      WithdrawSaver withdrawSaver) {
        this.accountLoader = accountLoader;
        this.withdrawSaver = withdrawSaver;
    }

    @Override
    public void withdraw(double amount) {
        var balance = accountLoader.loadBalance();
        if (hasFundsToWithdraw(amount, balance)) {
            throw new NoFundsException();
        }
        if (amount < 1) {
            throw new MinimumOneDollarWithdrawalException();
        }
        withdrawSaver.save(amount);
    }

    private static boolean hasFundsToWithdraw(double amount, double balance) {
        return balance - amount < 0.0;
    }
}
