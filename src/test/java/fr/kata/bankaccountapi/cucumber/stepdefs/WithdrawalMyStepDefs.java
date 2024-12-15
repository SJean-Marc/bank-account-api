package fr.kata.bankaccountapi.cucumber.stepdefs;

import fr.kata.bankaccountapi.cucumber.service.UserActionService;
import io.cucumber.java.en.When;
import org.springframework.boot.test.web.server.LocalServerPort;

public class WithdrawalMyStepDefs {
    private final int serverPort;
    private final UserActionService userActionService;

    public WithdrawalMyStepDefs(@LocalServerPort int serverPort,
                                UserActionService userActionService) {
        this.serverPort = serverPort;
        this.userActionService = userActionService;
    }

    @When("the client make a withdrawal of ${double} from the account")
    public void theClientMakeAWithdrawalFromTheAccount(double withdrawMoney) {
        try {
            userActionService.withdraw(serverPort, withdrawMoney);
        } catch (RuntimeException exception) {

        }
    }
}
