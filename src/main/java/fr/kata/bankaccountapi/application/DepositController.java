package fr.kata.bankaccountapi.application;

import fr.kata.bankaccountapi.application.dto.MoneyDepositedDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {
    @PostMapping("/deposit")
    public void deposit(@RequestBody MoneyDepositedDto moneyDeposited) {
    }
}