package fr.kata.bankaccountapi.domain.api;

import fr.kata.bankaccountapi.domain.model.AccountStatement;
import java.util.Collection;

@FunctionalInterface
public interface AccountStatementsHistory {
    Collection<AccountStatement> findAllMovements();
}
