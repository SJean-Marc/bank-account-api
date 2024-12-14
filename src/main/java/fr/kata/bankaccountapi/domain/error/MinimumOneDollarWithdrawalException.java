package fr.kata.bankaccountapi.domain.error;

public class MinimumOneDollarWithdrawalException extends RuntimeException {
    public MinimumOneDollarWithdrawalException() {
        super("Minimum for Withdrawal is $1");
    }
}
