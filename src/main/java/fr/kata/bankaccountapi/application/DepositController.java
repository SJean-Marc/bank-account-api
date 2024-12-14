package fr.kata.bankaccountapi.application;

import fr.kata.bankaccountapi.application.dto.MoneyDepositedDto;
import fr.kata.bankaccountapi.domain.api.DepositToAccount;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {
    private final DepositToAccount depositToAccount;

    public DepositController(DepositToAccount depositToAccount) {
        this.depositToAccount = depositToAccount;
    }

    @PostMapping("/deposit")
    public void deposit(@RequestBody MoneyDepositedDto moneyDeposited) {
        depositToAccount.deposit(moneyDeposited.getAmount());
    }
}
