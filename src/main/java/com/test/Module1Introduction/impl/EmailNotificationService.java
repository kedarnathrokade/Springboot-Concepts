package com.test.Module1Introduction.impl;

import com.test.Module1Introduction.NotificationService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary // This annotation is used to run this class when multiple implementations are present
@Component  // This annotation will create a bean of this class
public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {

        System.out.println("Sending Email " + message);
    }
}
