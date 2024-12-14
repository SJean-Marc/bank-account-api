package fr.kata.bankaccountapi.domain.error;

public class NoFundsException extends RuntimeException {
    public NoFundsException() {
        super("No funds available on the account");
    }
}
