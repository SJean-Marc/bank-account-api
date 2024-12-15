package fr.kata.bankaccountapi.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.kata.bankaccountapi.domain.model.AccountStatementWithBalance;
import fr.kata.bankaccountapi.domain.model.AccountStatementTransaction;
import fr.kata.bankaccountapi.domain.spi.AccountLoader;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

class AccountStatementsHistoryInDollarTest {
    private static final LocalDate DATE = LocalDate.of(2021, 1, 1);
    private final AccountLoader accountLoader = mock(AccountLoader.class);
    private final AccountStatementsHistoryInDollar accountStatementsHistoryInDollar =
        new AccountStatementsHistoryInDollar(accountLoader);

    @Test
    void should_return_empty_list_when_no_transaction() {
        when(accountLoader.loadAllAccountTransactions()).thenReturn(List.of());

        assertThat(accountStatementsHistoryInDollar.findAllMovements()).isEmpty();
    }

    @Test
    void on_each_transaction_sum_of_all_previous_transactions_to_get_balance() {
        when(accountLoader.loadAllAccountTransactions()).thenReturn(List.of(
            new AccountStatementTransaction(1L, DATE, 200.0),
            new AccountStatementTransaction(2L, DATE, -100.0),
            new AccountStatementTransaction(3L, DATE, 300.0)
        ));

        assertThat(accountStatementsHistoryInDollar.findAllMovements())
            .usingRecursiveFieldByFieldElementComparator()
            .isEqualTo(List.of(
                new AccountStatementWithBalance(DATE, 200.0, 200.0),
                new AccountStatementWithBalance(DATE, -100.0, 100.0),
                new AccountStatementWithBalance(DATE, 300.0, 400.0)
            ));
    }
}
