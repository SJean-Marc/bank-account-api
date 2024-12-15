package fr.kata.bankaccountapi.domain.api;

@FunctionalInterface
public interface WithdrawFromAccount {
    void withdraw(double amount);
}
