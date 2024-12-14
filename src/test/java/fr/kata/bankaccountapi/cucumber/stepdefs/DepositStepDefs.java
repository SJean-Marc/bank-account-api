package fr.kata.bankaccountapi.cucumber.stepdefs;

import io.cucumber.java.en.When;

public class DepositStepDefs {
    @When("the client deposits {int}$ into the account")
    public void theClientDepositsMoneyIntoTheAccount(int moneyDeposited) {
    }
}
