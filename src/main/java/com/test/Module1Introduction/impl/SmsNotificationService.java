package com.test.Module1Introduction.impl;

import com.test.Module1Introduction.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sms")
public class SmsNotificationService implements NotificationService {


    @Override
    public void send(String message) {

        System.out.println("Seding SMS " + message);

    }
}
