package fr.kata.bankaccountapi.domain.spi;

@FunctionalInterface
public interface AccountSaver {
    void save(double amount);
}
