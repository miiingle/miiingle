package com.mingle2.apiserver;

import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiServerApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

	}

	@Bean
    FirebaseDatabase firebaseDatabase() {
        FirebaseOptions options = new FirebaseOptions().

        FirebaseAuth auth = new FirebaseAuth();
        auth.set
    }

}
