package com.mingle2.poc.neo4j;

import com.mingle2.poc.neo4j.model.Person;
import com.mingle2.poc.neo4j.restrepository.PersonRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
@Log
public class PocNeo4jApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PocNeo4jApplication.class, args);
	}

	@Autowired
	PersonRepository personRepository;

	@Override
	public void run(String... strings) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (true) {
            log.info("Add Friends:");
			Long f1 = scanner.nextLong();
			Long f2 = scanner.nextLong();

			try {
				Person p1 = personRepository.findOne(f1);
				Person p2 = personRepository.findOne(f2);

                log.info("P1: " + p1 + " P2:" + p2);
                log.info("Go?");
                log.info("=============================");
				p1.addFriend(p2);

				personRepository.save(p1);
                log.info("Saved...");
			} catch (Exception e) {
				scanner.close();
			}
		}
	}
}
