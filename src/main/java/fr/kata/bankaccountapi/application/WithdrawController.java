package fr.kata.bankaccountapi.application;

import fr.kata.bankaccountapi.application.dto.MoneyToWithdrawDto;
import fr.kata.bankaccountapi.domain.api.WithdrawFromAccount;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WithdrawController {
    private final WithdrawFromAccount withdrawFromAccount;

    public WithdrawController(WithdrawFromAccount withdrawFromAccount) {
        this.withdrawFromAccount = withdrawFromAccount;
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestBody MoneyToWithdrawDto moneyToWithdraw) {
        withdrawFromAccount.withdraw(moneyToWithdraw.getAmount());
    }
}
