package com.test.Module1Introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module1IntroductionApplication implements CommandLineRunner {

	@Autowired
	PaymentService paymentService;

	@Override
	public void run(String... args) throws Exception {

		paymentService.pay();

	}

	public static void main(String[] args) {

		 PaymentService paymentService;


		SpringApplication.run(Module1IntroductionApplication.class, args);

		System.out.println("Appliction started successfully.");

//		PaymentService paymentService = new PaymentService();  tight coupling


	}


}
