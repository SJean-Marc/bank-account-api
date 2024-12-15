package fr.kata.bankaccountapi;

import fr.kata.bankaccountapi.cucumber.conf.CucumberConfig;
import fr.kata.bankaccountapi.infrastructure.repository.AccountStatementRepository;
import io.cucumber.java.Before;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@CucumberContextConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BankAccountApiApplication.class, CucumberConfig.class},
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberOptions(features = "src/test/resources")
public class CucumberIntegrationRunner {
    @Autowired
    private AccountStatementRepository accountStatementRepository;

    @Before
    public void setup() {
        accountStatementRepository.deleteAll();
    }
}
