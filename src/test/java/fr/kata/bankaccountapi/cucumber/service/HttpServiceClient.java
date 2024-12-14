package fr.kata.bankaccountapi.cucumber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpServiceClient {
    private static final String BASE_URL = "http://localhost:";
    private final RestTemplate restTemplate;

    @Autowired
    public HttpServiceClient(final RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public ResponseEntity<String> getVersion(int serverPort) {
        var url = buildFullUrl("/version", serverPort);
        return restTemplate.getForEntity(url, String.class);
    }

    private String buildFullUrl(String endpoint, int serverPort) {
        return BASE_URL + serverPort + endpoint;
    }
}
