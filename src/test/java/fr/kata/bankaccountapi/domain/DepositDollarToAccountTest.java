package fr.kata.bankaccountapi.domain;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import fr.kata.bankaccountapi.domain.spi.AccountSaver;
import org.junit.jupiter.api.Test;

class DepositDollarToAccountTest {
    private final AccountSaver accountSaver =
        mock(AccountSaver.class);

    private final DepositDollarsToAccount depositDollarToAccount =
        new DepositDollarsToAccount(accountSaver);

    @Test
    void should_do_nothing_when_amount_is_equal_than_0() {
        depositDollarToAccount.deposit(0.0);

        verify(accountSaver, never()).save(anyDouble());
    }

    @Test
    void should_do_nothing_when_amount_is_lower_than_0() {
        depositDollarToAccount.deposit(-1);

        verify(accountSaver, never()).save(anyDouble());
    }

    @Test
    void should_update_when_amount_is_higher_than_0() {
        depositDollarToAccount.deposit(1);

        verify(accountSaver, times(1)).save(anyDouble());
    }
}
