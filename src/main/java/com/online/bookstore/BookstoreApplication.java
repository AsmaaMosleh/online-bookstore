package com.online.bookstore;

import com.online.bookstore.service.SeedDataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	private SeedDataService seedDataService;

	public BookstoreApplication(SeedDataService seedDataService) {
		this.seedDataService = seedDataService;
	}


	public static void main(String[] args) {

		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Seed data when the application starts
		seedDataService.seedData();
	}
}
