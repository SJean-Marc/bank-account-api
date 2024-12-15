package fr.kata.bankaccountapi.cucumber.service;

import fr.kata.bankaccountapi.application.dto.AccountStatementDto;
import fr.kata.bankaccountapi.application.dto.MoneyDepositedDto;
import fr.kata.bankaccountapi.application.dto.MoneyToWithdrawDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserActionService {
    private final HttpServiceClient httpServiceClient;

    public UserActionService(HttpServiceClient httpServiceClient) {
        this.httpServiceClient = httpServiceClient;
    }

    public void deposit(int serverPort, int moneyDeposited) {
        httpServiceClient.post("/deposit", serverPort, new MoneyDepositedDto(moneyDeposited));
    }

    public ResponseEntity<String> recoverVersion(int serverPort) {
        return httpServiceClient.get("/version", serverPort, String.class);
    }

    public void withdraw(int serverPort, double withdrawMoney) {
        httpServiceClient.post("/withdraw", serverPort, new MoneyToWithdrawDto(withdrawMoney));
    }

    public ResponseEntity<AccountStatementDto[]> accountStatement(int serverPort) {
        return httpServiceClient.get("/account-statement", serverPort,
            AccountStatementDto[].class);
    }
}
