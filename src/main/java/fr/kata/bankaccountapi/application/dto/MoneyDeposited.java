package fr.kata.bankaccountapi.application.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MoneyDeposited {
    private final double amount;

    @JsonCreator
    public MoneyDeposited(@JsonProperty("amount") double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
