package fr.kata.bankaccountapi.domain.api;

@FunctionalInterface
public interface WithdrawFromAccount {
    double withdraw(double amount);
}
