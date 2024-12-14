package fr.kata.bankaccountapi.domain.model;

import java.time.LocalDate;

public record AccountStatement(LocalDate date,
                               double amount,
                               double balance) {
}
