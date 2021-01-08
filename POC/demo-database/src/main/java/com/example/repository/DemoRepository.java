package com.example.repository;

import com.example.entities.Demo;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface DemoRepository extends CrudRepository<Demo, Long> {
}
