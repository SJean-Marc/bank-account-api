package fr.kata.bankaccountapi.domain.spi;

@FunctionalInterface
public interface AccountSaver {
    double save(double amount);
}
