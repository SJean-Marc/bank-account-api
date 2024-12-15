package fr.kata.bankaccountapi;

import fr.kata.bankaccountapi.cucumber.conf.CucumberConfig;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@CucumberContextConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BankAccountApiApplication.class, CucumberConfig.class},
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberOptions(features = "src/test/resources")
public class CucumberIntegrationRunner {
}
