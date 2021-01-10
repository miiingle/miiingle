package com.example;

import io.micronaut.core.annotation.Introspected;
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

    /**
     * curl "http://localhost:8080/hello?name=test"
     */
    @Secured(SecurityRule.IS_ANONYMOUS)
    @Get(uri="/hello")
    public Ping index(String name) {
        return new Ping(name);
    }

    @Introspected
    public static class Ping {

        private final String name;

        public Ping(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    /**
     curl "http://localhost:8080/user" \
     --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzaGVybG9jayIsIm5iZiI6MTYxMDI1MTk3OSwicm9sZXMiOltdLCJpc3MiOiJkZW1vLXNlY3VyaXR5IiwiZXhwIjoxNjEwMjU1NTc5LCJpYXQiOjE2MTAyNTE5Nzl9.S7bXPUkDG4daCHjvi4LGV-w4k1m2gH_1cAThrHoNm8A' \
     --verbose
    */
    @Secured(SecurityRule.IS_AUTHENTICATED)
    @Get("/user")
    public Principal currentUser(Principal principal) {
        return principal;
    }
}