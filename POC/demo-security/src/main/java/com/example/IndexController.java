package com.example;

import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/index")
public class IndexController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}