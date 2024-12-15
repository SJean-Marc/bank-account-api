package fr.kata.bankaccountapi.domain.error;

public class ValueDepositedNotAcceptedException extends RuntimeException {
    public ValueDepositedNotAcceptedException() {
        super("Deposit amount should be higher than 0.01");
    }
}
