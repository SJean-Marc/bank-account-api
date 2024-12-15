package fr.kata.bankaccountapi.domain.spi;

import fr.kata.bankaccountapi.domain.model.AccountStatementTransaction;
import java.util.Collection;

public interface AccountLoader {
    double loadBalance();
    Collection<AccountStatementTransaction> loadAllAccountTransactions();
}
