package fr.kata.bankaccountapi.cucumber.stepdefs;

import static org.mockito.Mockito.when;

import fr.kata.bankaccountapi.infrastructure.service.CurrentDateService;
import io.cucumber.java.en.Given;
import java.time.LocalDate;

public class TimeStepDefs {
    private final CurrentDateService currentDateService;

    public TimeStepDefs(CurrentDateService currentDateService) {
        this.currentDateService = currentDateService;
    }

    @Given("today date is {string}")
    public void todayDateIs(String currentDate) {
        when(currentDateService.getCurrentDate()).thenReturn(LocalDate.parse(currentDate));
    }
}
