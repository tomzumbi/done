package org.example.service.impl;

import org.example.DAO.UserDAO.LoginDAO;
import org.example.DAO.UserDAO.RegisterDAO;
import org.example.model.User;
import org.example.service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    RegisterDAO dao = new RegisterDAO();
    LoginDAO loginDao = new LoginDAO();
    @Override
    public boolean register(User user) {
        return dao.register(user);
    }

    @Override
    public boolean checkEmail(String email) {
        return  dao.checkEmail(email);
    }

    @Override
    public boolean checkPhoneNumber(String phone) {
        return dao.checkPhoneNumber(phone);
    }

    @Override
    public boolean checkUsername(String username) {
        return dao.checkUsername(username);
    }

    @Override
    public User findByUserName(String userName) {
        return loginDao.findByUserName(userName);
    }

    @Override
    public boolean forgotPassword(User user) {
        return loginDao.forgetPassword(user);
    }
}
