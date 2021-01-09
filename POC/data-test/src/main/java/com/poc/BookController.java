package com.poc;

import io.micronaut.http.annotation.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller("/book")
public class BookController {

    private final BookRepository bookRepository;

    @Get
    public Iterable<Book> index() {
        return bookRepository.findAll();
    }
}