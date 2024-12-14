package fr.kata.bankaccountapi.application.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MoneyToWithdrawDto {
    private final double amount;

    @JsonCreator
    public MoneyToWithdrawDto(@JsonProperty("amount") double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
