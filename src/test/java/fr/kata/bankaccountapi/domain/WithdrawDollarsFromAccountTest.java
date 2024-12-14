package fr.kata.bankaccountapi.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import fr.kata.bankaccountapi.domain.api.WithdrawFromAccount;
import fr.kata.bankaccountapi.domain.error.MinimumOneDollarWithdrawalException;
import fr.kata.bankaccountapi.domain.error.NoFundsException;
import fr.kata.bankaccountapi.domain.spi.AccountLoader;
import fr.kata.bankaccountapi.domain.spi.WithdrawSaver;
import org.junit.jupiter.api.Test;

class WithdrawDollarsFromAccountTest {
    private final AccountLoader accountLoader = mock(AccountLoader.class);
    private final WithdrawSaver withdrawSaver = mock(WithdrawSaver.class);
    private final WithdrawFromAccount withdrawFromAccount =
        new WithdrawDollarsFromAccount(accountLoader, withdrawSaver);

    @Test
    void should_return_error_when_no_money_to_withdraw() {
        when(accountLoader.loadBalance()).thenReturn(0.0);

        assertThrows(NoFundsException.class, () -> withdrawFromAccount.withdraw(100));
    }

    @Test
    void should_return_error_when_account_balance_is_lower_than_the_money_requested_to_withdraw() {
        when(accountLoader.loadBalance()).thenReturn(10.0);

        assertThrows(NoFundsException.class, () -> withdrawFromAccount.withdraw(100));
    }

    @Test
    void should_return_error_when_try_to_withdraw_money_lower_than_1_dollar() {
        when(accountLoader.loadBalance()).thenReturn(10.0);

        assertThrows(MinimumOneDollarWithdrawalException.class,
            () -> withdrawFromAccount.withdraw(0.5));
    }

    @Test
    void should_withdraw_money_when_balance_and_withdrawal_request_produce_an_positive_balance() {
        when(accountLoader.loadBalance()).thenReturn(10.0);

        withdrawFromAccount.withdraw(5);

        verify(withdrawSaver, times(1)).save(5);
    }
}
