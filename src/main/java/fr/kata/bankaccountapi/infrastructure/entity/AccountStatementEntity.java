package fr.kata.bankaccountapi.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ACCOUNT_STATEMENT")
public class AccountStatementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TRANSACTION_AMOUNT", nullable = false)
    private Double transactionAmount;

    public AccountStatementEntity() {
    }

    public AccountStatementEntity(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Long getId() {
        return id;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }
}
