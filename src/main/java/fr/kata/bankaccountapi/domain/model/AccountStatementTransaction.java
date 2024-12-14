package fr.kata.bankaccountapi.domain.model;

import java.time.LocalDate;

public record AccountStatementTransaction(Long identifier,
                                          LocalDate date,
                                          double transactionAmount) {
}
