package net.miiingle.backend.presentation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class RootControllerTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    public void testPing() {
        HttpRequest<String> request = HttpRequest.GET("/ping");
        RootController.Pong response = client.toBlocking().retrieve(request, RootController.Pong.class);

        assertNotNull(response);
    }

    @Test
    public void testEcho() {
        RootController.Pong body = new RootController.Pong(123L, "test");
        HttpRequest<RootController.Pong> request = HttpRequest.POST("/echo", body);

        RootController.Pong response = client.toBlocking().retrieve(request, RootController.Pong.class);

        assertNotNull(response);
        assertEquals("test", response.getParam());
        assertEquals(123L, response.getId());
    }
}
