package fr.kata.bankaccountapi.domain.api;

@FunctionalInterface
public interface DepositToAccount {
    void deposit(double amount);
}
