package com.example;

import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.security.Principal;

@Controller("/")
public class IndexController {

    /*
     *

    login
    https://micronaut-projects.github.io/micronaut-security/latest/guide/#login

     curl -X "POST" "http://localhost:8080/login" \
     -H 'Content-Type: application/json; charset=utf-8' \
     -d $'{
     "username": "sherlock",
     "password": "password"
     }' --verbose

     */

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Get(uri="/index", produces="text/plain")
    public String index() {
        return "Example Response";
    }

    @Secured(SecurityRule.IS_AUTHENTICATED)
    @Get("/user")
    public Principal currentUser(Principal principal) {
        return principal;
    }
}