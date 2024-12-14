package fr.kata.bankaccountapi.domain.spi;

@FunctionalInterface
public interface AccountLoader {
    double loadBalance();
}
