package fr.kata.bankaccountapi.application;

import fr.kata.bankaccountapi.application.dto.AccountStatementDto;
import fr.kata.bankaccountapi.domain.api.AccountStatementsHistory;
import fr.kata.bankaccountapi.domain.model.AccountStatement;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountStatementHistoryController {
    private final AccountStatementsHistory accountStatementsHistory;

    public AccountStatementHistoryController(AccountStatementsHistory accountStatementsHistory) {
        this.accountStatementsHistory = accountStatementsHistory;
    }

    @GetMapping("/account-statement")
    public List<AccountStatementDto> withdraw() {
        return accountStatementsHistory.findAllMovements()
            .stream()
            .map(this::mapToDto)
            .toList();
    }

    private AccountStatementDto mapToDto(AccountStatement accountStatement) {
        return new AccountStatementDto(accountStatement.date(),
                                       accountStatement.amount(),
                                       accountStatement.balance());
    }
}
