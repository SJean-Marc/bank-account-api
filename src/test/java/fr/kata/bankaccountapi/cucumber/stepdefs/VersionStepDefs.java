package fr.kata.bankaccountapi.cucumber.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import fr.kata.bankaccountapi.cucumber.data.VersionStepsData;
import fr.kata.bankaccountapi.cucumber.service.UserActionService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;

public class VersionStepDefs {
    private final int serverPort;
    private final UserActionService userActionService;

    public VersionStepDefs(@LocalServerPort int serverPort,
                           @Autowired UserActionService userActionService) {
        this.serverPort = serverPort;
        this.userActionService = userActionService;
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int statusCode) {
        assertThat(VersionStepsData.getStatus()).isEqualTo(statusCode);

    }

    @When("the client calls version page")
    public void whenCallVersionPage() {
        final var version = userActionService.recoverVersion(serverPort);
        VersionStepsData.setVersionAndStatusCode(version.getBody(),
            version.getStatusCode().value());
    }

    @And("the client receives server version {double}")
    public void theClientReceivesServerVersion(double version) {
        assertThat(VersionStepsData.getVersion()).isEqualTo(String.valueOf(version));
    }
}
