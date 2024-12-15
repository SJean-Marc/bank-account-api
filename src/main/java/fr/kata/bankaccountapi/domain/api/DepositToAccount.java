package fr.kata.bankaccountapi.domain.api;

@FunctionalInterface
public interface DepositToAccount {
    double deposit(double amount);
}
