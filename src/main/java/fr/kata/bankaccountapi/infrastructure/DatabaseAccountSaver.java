package fr.kata.bankaccountapi.infrastructure;

import fr.kata.bankaccountapi.domain.spi.AccountSaver;
import fr.kata.bankaccountapi.infrastructure.entity.AccountStatementEntity;
import fr.kata.bankaccountapi.infrastructure.repository.AccountStatementRepository;
import fr.kata.bankaccountapi.infrastructure.service.CurrentDateService;
import org.springframework.stereotype.Service;

@Service
public class DatabaseAccountSaver implements AccountSaver {
    private final AccountStatementRepository accountStatementRepository;
    private final CurrentDateService currentDateService;

    public DatabaseAccountSaver(AccountStatementRepository accountStatementRepository,
                                CurrentDateService currentDateService) {
        this.accountStatementRepository = accountStatementRepository;
        this.currentDateService = currentDateService;
    }

    @Override
    public double save(double amount) {
        var depositSaved = accountStatementRepository.save(
            new AccountStatementEntity(amount, currentDateService.getCurrentDate()));
        return depositSaved.getTransactionAmount();
    }
}
