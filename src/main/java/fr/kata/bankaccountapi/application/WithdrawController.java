package fr.kata.bankaccountapi.application;

import fr.kata.bankaccountapi.application.dto.MoneyToWithdrawDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WithdrawController {
    @PostMapping("/withdraw")
    public void withdraw(@RequestBody MoneyToWithdrawDto moneyToWithdraw) {
    }
}
