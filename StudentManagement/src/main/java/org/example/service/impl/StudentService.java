package org.example.service.impl;

import org.example.DAO.StudentDAO.StudentDAO;
import org.example.model.User;
import org.example.service.IStudentService;

public class StudentService implements IStudentService {
    StudentDAO studentDAO = new StudentDAO();

    @Override
    public boolean updateInformation(User user) {
        return studentDAO.updateInformation(user);
    }

    @Override
    public boolean editEmail(User user) {
        return studentDAO.editEmail(user);
    }

    @Override
    public boolean editPhone(User user) {
        return studentDAO.editPhone(user);
    }

    @Override
    public boolean checkEmail(String email) {
        return studentDAO.checkEmail(email);
    }

    @Override
    public boolean checkPhoneNumber(String phone) {
        return studentDAO.checkPhoneNumber(phone);
    }


}
