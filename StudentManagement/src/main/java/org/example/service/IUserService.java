package org.example.service;

import org.example.model.User;

import java.util.List;

public interface IUserService {
    boolean register(User user);
    boolean checkEmail(String email);
    boolean checkPhoneNumber(String phone);
    boolean checkUsername(String username);
    User findByUserName(String userName);
    boolean forgotPassword(User user);
}
