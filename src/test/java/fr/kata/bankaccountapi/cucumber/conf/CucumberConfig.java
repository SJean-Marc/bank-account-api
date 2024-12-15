package fr.kata.bankaccountapi.cucumber.conf;

import static org.mockito.Mockito.spy;

import fr.kata.bankaccountapi.infrastructure.service.CurrentDateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CucumberConfig {
    @Bean
    public CurrentDateService currentDateService() {
        return spy(new CurrentDateService());
    }
}
