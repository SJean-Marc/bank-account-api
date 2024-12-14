package fr.kata.bankaccountapi.domain;

import fr.kata.bankaccountapi.domain.api.AccountStatementsHistory;
import fr.kata.bankaccountapi.domain.model.AccountStatement;
import fr.kata.bankaccountapi.domain.model.AccountStatementTransaction;
import fr.kata.bankaccountapi.domain.spi.AccountLoader;
import java.util.Collection;
import java.util.function.Predicate;

public class AccountStatementsHistoryInDollar implements AccountStatementsHistory {
    private final AccountLoader accountLoader;

    public AccountStatementsHistoryInDollar(AccountLoader accountLoader) {
        this.accountLoader = accountLoader;
    }

    @Override
    public Collection<AccountStatement> findAllMovements() {
        return accountLoader.loadAllAccountTransactions()
            .stream()
            .map(this::buildAccountStatement)
            .toList();
    }

    private AccountStatement buildAccountStatement(
        AccountStatementTransaction accountStatementTransaction) {
        return new AccountStatement(
            accountStatementTransaction.date(),
            accountStatementTransaction.transactionAmount(),
            calculateBalance(accountStatementTransaction)
        );
    }

    private double calculateBalance(AccountStatementTransaction lastTransaction) {
        return accountLoader.loadAllAccountTransactions()
            .stream()
            .filter(removeAllAfterLastTransaction(lastTransaction))
            .mapToDouble(AccountStatementTransaction::transactionAmount)
            .sum();
    }

    private static Predicate<AccountStatementTransaction> removeAllAfterLastTransaction(
        AccountStatementTransaction lastTransaction) {
        return currentTransaction -> currentTransaction.identifier() <=
            lastTransaction.identifier();
    }
}
