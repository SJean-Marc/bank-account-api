package fr.kata.bankaccountapi.domain.spi;

@FunctionalInterface
public interface AccountTransactionSaver {
    void save(double amount);
}
