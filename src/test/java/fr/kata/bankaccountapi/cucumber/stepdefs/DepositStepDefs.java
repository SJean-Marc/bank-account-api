package fr.kata.bankaccountapi.cucumber.stepdefs;

import fr.kata.bankaccountapi.cucumber.service.UserActionService;
import io.cucumber.java.en.When;
import org.springframework.boot.test.web.server.LocalServerPort;

public class DepositStepDefs {
    private final int serverPort;
    private final UserActionService userActionService;

    public DepositStepDefs(@LocalServerPort int serverPort,
                           UserActionService userActionService) {
        this.serverPort = serverPort;
        this.userActionService = userActionService;
    }

    @When("the client deposit ${int} into the account")
    public void theClientDepositsMoneyIntoTheAccount(int moneyDeposited) {
        userActionService.deposit(serverPort, moneyDeposited);
    }
}
