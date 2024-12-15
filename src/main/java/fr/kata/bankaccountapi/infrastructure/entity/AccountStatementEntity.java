package fr.kata.bankaccountapi.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "ACCOUNT_STATEMENT")
public class AccountStatementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TRANSACTION_AMOUNT", nullable = false)
    private Double transactionAmount;

    @Column(name = "DATE", nullable = false)
    private LocalDate date = LocalDate.now();

    public AccountStatementEntity() {
    }

    public AccountStatementEntity(double transactionAmount,
                                  LocalDate date) {
        this.transactionAmount = transactionAmount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public LocalDate getDate() {
        return date;
    }
}
