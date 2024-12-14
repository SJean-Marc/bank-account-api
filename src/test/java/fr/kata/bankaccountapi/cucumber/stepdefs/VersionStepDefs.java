package fr.kata.bankaccountapi.cucumber.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VersionStepDefs {
    @When("the client calls version page")
    public void whenCallVersionPage() {
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int statusCode) {

    }

    @And("the client receives server version {double}")
    public void theClientReceivesServerVersion(double version) {

    }
}
