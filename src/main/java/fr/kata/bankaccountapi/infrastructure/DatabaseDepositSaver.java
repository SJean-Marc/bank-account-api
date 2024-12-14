package fr.kata.bankaccountapi.infrastructure;

import fr.kata.bankaccountapi.domain.spi.DepositSaver;
import fr.kata.bankaccountapi.infrastructure.entity.AccountStatementEntity;
import fr.kata.bankaccountapi.infrastructure.repository.AccountStatementRepository;
import org.springframework.stereotype.Service;

@Service
public class DatabaseDepositSaver implements DepositSaver {
    private final AccountStatementRepository accountStatementRepository;

    public DatabaseDepositSaver(AccountStatementRepository accountStatementRepository) {
        this.accountStatementRepository = accountStatementRepository;
    }

    @Override
    public void save(double amount) {
        accountStatementRepository.save(new AccountStatementEntity(amount));
    }
}
