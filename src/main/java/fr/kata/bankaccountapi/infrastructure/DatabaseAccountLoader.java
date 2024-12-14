package fr.kata.bankaccountapi.infrastructure;

import fr.kata.bankaccountapi.domain.spi.AccountLoader;
import fr.kata.bankaccountapi.infrastructure.entity.AccountStatementEntity;
import fr.kata.bankaccountapi.infrastructure.repository.AccountStatementRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseAccountLoader implements AccountLoader {
    private final AccountStatementRepository accountStatementRepository;

    public DatabaseAccountLoader(AccountStatementRepository accountStatementRepository) {
        this.accountStatementRepository = accountStatementRepository;
    }

    @Override
    public double loadBalance() {
        return accountStatementRepository.findAll()
            .stream()
            .map(AccountStatementEntity::getTransactionAmount)
            .reduce(0.0, Double::sum);
    }
}
