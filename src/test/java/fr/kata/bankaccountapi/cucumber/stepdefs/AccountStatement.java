package fr.kata.bankaccountapi.cucumber.stepdefs;

public record AccountStatement(String date,
                               double amount,
                               double balance) {
}
