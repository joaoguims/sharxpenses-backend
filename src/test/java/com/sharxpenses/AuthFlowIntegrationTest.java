package com.sharxpenses;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthFlowIntegrationTest {

    @Autowired
    private TestRestTemplate rest;

    @Test
    void registerLoginFlow() {
        // Register
        String body = "{ \""email\"": \""test@example.com\"", \""password\"": \""123456\"", \""name\"": \""Test\""}";
        ResponseEntity<String> reg = rest.postForEntity("/auth/register", body, String.class);
        assertThat(reg.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Login
        String login = "{ \""email\"": \""test@example.com\"", \""password\"": \""123456\""}";
        ResponseEntity<String> log = rest.postForEntity("/auth/login", login, String.class);
        assertThat(log.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
