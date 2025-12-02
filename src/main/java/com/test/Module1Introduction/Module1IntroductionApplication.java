package com.test.Module1Introduction;

import com.test.Module1Introduction.impl.EmailNotificationService;
import com.test.Module1Introduction.impl.SmsNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Module1IntroductionApplication implements CommandLineRunner {

	// @Autowired
//		final NotificationService notificationService;
//
//
//	Module1IntroductionApplication(@Qualifier("sms") NotificationService noticationService){
//		this.notificationService = noticationService; // Constructor DI
//
//	}

	@Autowired
	Map<String, NotificationService> notificationServiceMap = new HashMap<>(); // creating all the beans



	@Override
	public void run(String... args) throws Exception {
		//
//		// NotificationService notificationServiceobj = new SmsNotificationService();
//		notificationService.send("Hello");

		for(var notificationService : notificationServiceMap.entrySet()){

			System.out.println(notificationService.getKey());
			notificationService.getValue().send("Hello"); // calling method of bean

		}


	}

	public static void main(String[] args) {




		SpringApplication.run(Module1IntroductionApplication.class, args);




	}


}
