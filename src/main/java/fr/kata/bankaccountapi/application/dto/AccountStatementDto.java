package fr.kata.bankaccountapi.application.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class AccountStatementDto {
    private final LocalDate date;
    private final double amount;
    private final double balance;

    @JsonCreator
    public AccountStatementDto(@JsonProperty("date") LocalDate date,
                               @JsonProperty("amount") double amount,
                               @JsonProperty("balance") double balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }
}
