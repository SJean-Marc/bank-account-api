package fr.kata.bankaccountapi.domain;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import fr.kata.bankaccountapi.domain.spi.AccountTransactionSaver;
import org.junit.jupiter.api.Test;

class DepositDollarToAccountTest {
    private final AccountTransactionSaver accountTransactionSaver =
        mock(AccountTransactionSaver.class);

    private final DepositDollarsToAccount depositDollarToAccount =
        new DepositDollarsToAccount(accountTransactionSaver);

    @Test
    void should_do_nothing_when_amount_is_equal_than_0() {
        depositDollarToAccount.deposit(0.0);

        verify(accountTransactionSaver, never()).save(anyDouble());
    }

    @Test
    void should_do_nothing_when_amount_is_lower_than_0() {
        depositDollarToAccount.deposit(-1);

        verify(accountTransactionSaver, never()).save(anyDouble());
    }

    @Test
    void should_update_when_amount_is_higher_than_0() {
        depositDollarToAccount.deposit(1);

        verify(accountTransactionSaver, times(1)).save(anyDouble());
    }
}
