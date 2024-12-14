package fr.kata.bankaccountapi.domain.spi;

@FunctionalInterface
public interface WithdrawSaver {
    void save(double amount);
}
