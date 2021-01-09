package com.poc;

import io.micronaut.data.annotation.*;
import io.micronaut.data.model.*;
import io.micronaut.data.repository.CrudRepository;

@Repository
interface BookRepository extends CrudRepository<Book, Long> {

}