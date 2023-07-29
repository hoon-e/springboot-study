package me.jaehoon.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

// Annotation
// Retention
// Target
// Test

class HelloApiTest {
    @Test
    void helloApiTest() {
        // http localhost:8080/hello?name=jaehoon
        // HTTPie
        TestRestTemplate restTemplate = new TestRestTemplate();

        ResponseEntity<String> respEntity =
                restTemplate.getForEntity("http://localhost:8080/app/hello?name={name}", String.class, "jaehoon");

        // status code 200
        Assertions.assertThat(respEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        // header(content-type) text/plain
        Assertions.assertThat(respEntity.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body Hello jaehoon
        Assertions.assertThat(respEntity.getBody()).isEqualTo("Hello jaehoon!!");
    }

    @Test
    void simpleHelloServiceTest() {
        SimpleHelloService service = new SimpleHelloService();
        String ret = service.sayHello("jaehoon");
        Assertions.assertThat(ret).isEqualTo("Hello jaehoon");
    }

    @Test
    void failsHelloApi() {
        TestRestTemplate restTemplate = new TestRestTemplate();

        ResponseEntity<String> respEntity =
                restTemplate.getForEntity("http://localhost:8080/app/hello?name=", String.class);

        // status code 500
        Assertions.assertThat(respEntity.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
