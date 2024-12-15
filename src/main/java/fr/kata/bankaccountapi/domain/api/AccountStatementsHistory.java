package fr.kata.bankaccountapi.domain.api;

import fr.kata.bankaccountapi.domain.model.AccountStatementWithBalance;
import java.util.Collection;

@FunctionalInterface
public interface AccountStatementsHistory {
    Collection<AccountStatementWithBalance> findAllMovements();
}
