package com.mingle2.poc.neo4j;

import com.mingle2.poc.neo4j.model.Person;
import com.mingle2.poc.neo4j.restrepository.PersonRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

/**

 add person 11 as friend of person 12
 curl -i -X PUT -H "Content-Type:text/uri-list" -d "http://localhost:17001/persons/11"  http://localhost:17001/persons/12/friends

 delete friend 12 from person 11
 curl -i -X DELETE http://localhost:17001/persons/11/friends/12
 */
@SpringBootApplication
@Log
public class PocNeo4jApplication  {

	public static void main(String[] args) {
		SpringApplication.run(PocNeo4jApplication.class, args);
	}
}
