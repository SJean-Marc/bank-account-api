package fr.kata.bankaccountapi.infrastructure;

import fr.kata.bankaccountapi.domain.model.AccountStatementTransaction;
import fr.kata.bankaccountapi.domain.spi.AccountLoader;
import fr.kata.bankaccountapi.infrastructure.entity.AccountStatementEntity;
import fr.kata.bankaccountapi.infrastructure.repository.AccountStatementRepository;
import java.util.Collection;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseAccountLoader implements AccountLoader {
    private final AccountStatementRepository accountStatementRepository;

    public DatabaseAccountLoader(AccountStatementRepository accountStatementRepository) {
        this.accountStatementRepository = accountStatementRepository;
    }

    @Override
    public double loadBalance() {
        return accountStatementRepository.sumTransactionAmount();
    }

    @Override
    public Collection<AccountStatementTransaction> loadAllAccountTransactions() {
        return accountStatementRepository.findAll()
            .stream()
            .map(this::mapToDomain)
            .toList();
    }

    private AccountStatementTransaction mapToDomain(AccountStatementEntity accountStatement) {
        return new AccountStatementTransaction(accountStatement.getId(),
                                               accountStatement.getDate(),
                                               accountStatement.getTransactionAmount());
    }
}
