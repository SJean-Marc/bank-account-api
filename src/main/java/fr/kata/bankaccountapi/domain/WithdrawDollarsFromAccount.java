package fr.kata.bankaccountapi.domain;

import fr.kata.bankaccountapi.domain.api.WithdrawFromAccount;
import fr.kata.bankaccountapi.domain.error.MinimumOneDollarWithdrawalException;
import fr.kata.bankaccountapi.domain.error.NoFundsException;
import fr.kata.bankaccountapi.domain.spi.AccountLoader;
import fr.kata.bankaccountapi.domain.spi.AccountTransactionSaver;

public class WithdrawDollarsFromAccount implements WithdrawFromAccount {
    private final AccountLoader accountLoader;
    private final AccountTransactionSaver accountTransactionSaver;

    public WithdrawDollarsFromAccount(AccountLoader accountLoader,
                                      AccountTransactionSaver accountTransactionSaver) {
        this.accountLoader = accountLoader;
        this.accountTransactionSaver = accountTransactionSaver;
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
        accountTransactionSaver.save(-amount);
    }

    private static boolean hasFundsToWithdraw(double amount, double balance) {
        return balance - amount < 0.0;
    }
}
