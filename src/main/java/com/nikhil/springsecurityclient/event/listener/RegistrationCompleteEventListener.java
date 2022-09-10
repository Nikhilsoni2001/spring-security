package com.nikhil.springsecurityclient.event.listener;

import com.nikhil.springsecurityclient.entity.User;
import com.nikhil.springsecurityclient.event.RegistrationCompleteEvent;
import com.nikhil.springsecurityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create Verification Token for User with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);

        // Send mail to User
        String url = event.getApplicationUrl() + "verifyRegistration?token=" + token;
        // sendVerificationEmail()
        log.info("Click the link to verify your account : {}", url);
    }
}
