package fr.kata.bankaccountapi.domain;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import fr.kata.bankaccountapi.domain.spi.DepositSaver;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DepositDollarToAccountTest {
    private final DepositSaver depositSaver = Mockito.mock(DepositSaver.class);
    private final DepositDollarsToAccount depositDollarToAccount =
        new DepositDollarsToAccount(depositSaver);

    @Test
    void should_do_nothing_when_amount_is_equal_than_0() {
        depositDollarToAccount.deposit(0.0);

        verify(depositSaver, never()).save(anyDouble());
    }

    @Test
    void should_do_nothing_when_amount_is_lower_than_0() {
        depositDollarToAccount.deposit(-1);

        verify(depositSaver, never()).save(anyDouble());
    }

    @Test
    void should_update_when_amount_is_higher_than_0() {
        depositDollarToAccount.deposit(1);

        verify(depositSaver, times(1)).save(anyDouble());
    }
}
