package com.mingle2.poc.neo4j.restrepository;

import com.mingle2.poc.neo4j.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "person")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}
