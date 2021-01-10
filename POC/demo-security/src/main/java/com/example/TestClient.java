package com.example;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;

@Client("/")
public interface TestClient {

    @Post("/login")
    BearerAccessRefreshToken login(@Body UsernamePasswordCredentials credentials);

    @Get("/hello")
    IndexController.Ping hello(@QueryValue String name);
}
