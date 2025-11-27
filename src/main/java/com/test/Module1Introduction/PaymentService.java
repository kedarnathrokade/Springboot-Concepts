package com.test.Module1Introduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    void pay(){
        System.out.println("Payment processed successfully.");

    }

    @PostConstruct
    public void preInitialize(){
        System.out.println("Before Paying....");
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("After Paying....");
    }

}
