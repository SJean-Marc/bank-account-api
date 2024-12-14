package fr.kata.bankaccountapi.infrastructure.service;

import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class CurrentDateService {
    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}
