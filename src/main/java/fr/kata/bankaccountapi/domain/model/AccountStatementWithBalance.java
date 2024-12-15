package fr.kata.bankaccountapi.domain.model;

import java.time.LocalDate;

public record AccountStatementWithBalance(LocalDate date,
                                          double amount,
                                          double balance) {
}
