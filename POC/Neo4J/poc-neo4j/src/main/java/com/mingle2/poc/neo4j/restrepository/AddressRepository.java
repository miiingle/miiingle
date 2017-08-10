package com.mingle2.poc.neo4j.restrepository;

import com.mingle2.poc.neo4j.model.Address;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "address")
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
}
