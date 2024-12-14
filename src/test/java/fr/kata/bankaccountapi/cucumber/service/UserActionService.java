package fr.kata.bankaccountapi.cucumber.service;

import fr.kata.bankaccountapi.application.dto.MoneyDeposited;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserActionService {
    private final HttpServiceClient httpServiceClient;

    public UserActionService(HttpServiceClient httpServiceClient) {
        this.httpServiceClient = httpServiceClient;
    }

    public void deposit(int serverPort, int moneyDeposited) {
        httpServiceClient.post("/deposit", serverPort, new MoneyDeposited(moneyDeposited));
    }

    public ResponseEntity<String> recoverVersion(int serverPort) {
        return httpServiceClient.get("/version", serverPort, String.class);
    }
}
