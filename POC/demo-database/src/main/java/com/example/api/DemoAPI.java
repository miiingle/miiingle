package com.example.api;

import com.example.entities.Demo;
import com.example.repository.DemoRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;

@Controller("/demo")
public class DemoAPI {

    @Inject
    DemoRepository demoRepository;

    @Get("/")
    Iterable<Demo> findAll() {
        return demoRepository.findAll();
    }

}
