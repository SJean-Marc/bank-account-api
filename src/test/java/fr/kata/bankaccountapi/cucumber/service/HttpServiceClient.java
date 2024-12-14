package fr.kata.bankaccountapi.cucumber.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpServiceClient {
    private static final String BASE_URL = "http://localhost:";
    private final RestTemplate restTemplate;

    public HttpServiceClient(final RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public <T> ResponseEntity<T> get(String endpoint, int serverPort, Class<T> responseType) {
        var url = buildFullUrl(endpoint, serverPort);
        return restTemplate.getForEntity(url, responseType);
    }

    public ResponseEntity<String> post(String endpoint,
                                       int serverPort,
                                       Object elementToPost) {
        var url = buildFullUrl(endpoint, serverPort);
        return restTemplate.postForEntity(url, elementToPost, String.class);
    }

    private String buildFullUrl(String endpoint, int serverPort) {
        return BASE_URL + serverPort + endpoint;
    }
}
