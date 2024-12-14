package fr.kata.bankaccountapi.domain.spi;

@FunctionalInterface
public interface DepositSaver {
    void save(double amount);
}
