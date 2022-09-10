package com.nikhil.springsecurityclient.service;

import com.nikhil.springsecurityclient.entity.User;
import com.nikhil.springsecurityclient.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
