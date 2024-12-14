package fr.kata.bankaccountapi.infrastructure;

import fr.kata.bankaccountapi.domain.spi.WithdrawSaver;
import fr.kata.bankaccountapi.infrastructure.entity.AccountStatementEntity;
import fr.kata.bankaccountapi.infrastructure.repository.AccountStatementRepository;
import org.springframework.stereotype.Service;

@Service
public class DatabaseWithdrawSaver implements WithdrawSaver {
    private final AccountStatementRepository accountStatementRepository;

    public DatabaseWithdrawSaver(AccountStatementRepository accountStatementRepository) {
        this.accountStatementRepository = accountStatementRepository;
    }

    @Override
    public void save(double amount) {
        accountStatementRepository.save(new AccountStatementEntity(-amount));
    }
}
