package org.example;

import org.example.DAO.AdminDAO.AdminDAO;
import org.example.controller.AdminController;
import org.example.model.Enrollment;
import org.example.model.Subject;
import org.example.model.User;
import org.example.service.impl.AdminService;
import org.example.view.UserView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        UserView userView = new UserView();
        userView.menuUserView();


    }
}
