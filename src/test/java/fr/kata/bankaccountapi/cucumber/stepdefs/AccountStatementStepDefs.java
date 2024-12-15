package fr.kata.bankaccountapi.cucumber.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import fr.kata.bankaccountapi.application.dto.AccountStatementDto;
import fr.kata.bankaccountapi.cucumber.data.AccountStatementStepData;
import fr.kata.bankaccountapi.cucumber.service.UserActionService;
import fr.kata.bankaccountapi.infrastructure.entity.AccountStatementEntity;
import fr.kata.bankaccountapi.infrastructure.repository.AccountStatementRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.boot.test.web.server.LocalServerPort;

public class AccountStatementStepDefs {
    private final int serverPort;
    private final UserActionService userActionService;
    private final AccountStatementRepository accountStatementRepository;

    public AccountStatementStepDefs(@LocalServerPort int serverPort,
                                    UserActionService userActionService,
                                    AccountStatementRepository accountStatementRepository) {
        this.serverPort = serverPort;
        this.userActionService = userActionService;
        this.accountStatementRepository = accountStatementRepository;
    }

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
        var actualAccountStatements = Stream.of(AccountStatementStepData.getAccountStatements())
            .map(this::mapToDto)
            .toList();

        assertThat(actualAccountStatements)
            .containsExactlyInAnyOrderElementsOf(expectedAccountStatements);
    }

    @When("the client request the account statement")
    public void theClientRequestTheAccountStatement() {
        AccountStatementStepData
            .setAccountStatements(userActionService.accountStatement(serverPort).getBody());
    }

    private AccountStatement mapToDto(AccountStatementDto accountStatement) {
        return new AccountStatement(
            accountStatement.getDate().toString(),
            accountStatement.getAmount(),
            accountStatement.getBalance()
        );
    }
}
