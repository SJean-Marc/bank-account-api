package fr.kata.bankaccountapi.cucumber.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import fr.kata.bankaccountapi.infrastructure.entity.AccountStatementEntity;
import fr.kata.bankaccountapi.infrastructure.repository.AccountStatementRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountStatementStepDefs {
    @Autowired
    private AccountStatementRepository accountStatementRepository;

    @Given("the client has ${int} on his bank account")
    public void defineTheClientBankAccountBalance(long balance) {
        accountStatementRepository.deleteAll();
        accountStatementRepository.save(new AccountStatementEntity(balance, LocalDate.now()));
    }

    @Then("the client receives the balance ${double}")
    public void theClientReceivesTheBalance$(double expectedAccountBalance) {
        var actualAccountBalance = accountStatementRepository.findAll()
            .stream()
            .map(AccountStatementEntity::getTransactionAmount)
            .reduce(Double::sum);

        assertThat(actualAccountBalance).hasValue(expectedAccountBalance);
    }

    @Then("the client receives")
    public void theClientReceives(List<AccountStatement> expectedAccountStatements) {
        var actualAccountStatements = accountStatementRepository.findAll()
            .stream()
            .map(this::mapToDto)
            .toList();

        assertThat(actualAccountStatements).containsExactlyElementsOf(expectedAccountStatements);
    }

    private AccountStatement mapToDto(AccountStatementEntity accountStatement) {
        return new AccountStatement(
            accountStatement.getDate().toString(),
            accountStatement.getTransactionAmount(),
            computeBalance(accountStatement)
        );
    }

    private double computeBalance(AccountStatementEntity lastStatement) {
        return accountStatementRepository.findAll()
            .stream()
            .filter(currentStatement -> currentStatement.getId() <= lastStatement.getId())
            .mapToDouble(AccountStatementEntity::getTransactionAmount)
            .sum();
    }
}
