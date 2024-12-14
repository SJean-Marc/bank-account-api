package fr.kata.bankaccountapi.infrastructure;

import fr.kata.bankaccountapi.domain.spi.AccountTransactionSaver;
import fr.kata.bankaccountapi.infrastructure.entity.AccountStatementEntity;
import fr.kata.bankaccountapi.infrastructure.repository.AccountStatementRepository;
import fr.kata.bankaccountapi.infrastructure.service.CurrentDateService;
import org.springframework.stereotype.Service;

@Service
public class DatabaseAccountTransactionSaver implements AccountTransactionSaver {
    private final AccountStatementRepository accountStatementRepository;
    private final CurrentDateService currentDateService;

    public DatabaseAccountTransactionSaver(AccountStatementRepository accountStatementRepository,
                                           CurrentDateService currentDateService) {
        this.accountStatementRepository = accountStatementRepository;
        this.currentDateService = currentDateService;
    }

    @Override
    public void save(double amount) {
        accountStatementRepository.save(
            new AccountStatementEntity(amount, currentDateService.getCurrentDate()));
    }
}
