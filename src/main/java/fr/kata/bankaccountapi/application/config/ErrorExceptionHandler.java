package fr.kata.bankaccountapi.application.config;

import fr.kata.bankaccountapi.domain.error.MinimumOneDollarWithdrawalException;
import fr.kata.bankaccountapi.domain.error.NoFundsException;
import fr.kata.bankaccountapi.domain.error.ValueDepositedNotAcceptedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorExceptionHandler {
    @ExceptionHandler({MinimumOneDollarWithdrawalException.class, NoFundsException.class,
        ValueDepositedNotAcceptedException.class})
    public ResponseEntity<String> handleExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Impossible to do the operation : " + ex.getMessage());
    }
}
