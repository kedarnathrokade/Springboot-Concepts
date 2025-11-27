package com.test.Module1Introduction;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PaymentService paymentService() {

        // You can write anything

        return new PaymentService(); // Returning the instance of PaymentService
    }
}
