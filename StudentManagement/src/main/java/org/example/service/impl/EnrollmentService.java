package org.example.service.impl;

import org.example.DAO.EnrollmentDAO.EnrollmentDAO;
import org.example.model.Enrollment;
import org.example.model.Subject;
import org.example.model.User;
import org.example.service.IEnrollmentService;

import java.util.Map;

public class EnrollmentService implements IEnrollmentService {
    EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
    @Override
    public Map<String, Object> getMyEnrollment(User user) {
        return enrollmentDAO.getMyEnrollment(user);
    }

    @Override
    public boolean checkEnrollment(User user) {
        return enrollmentDAO.checkEnrollment(user);
    }

    @Override
    public void addEnroll(Enrollment enrollment) {
        enrollmentDAO.addEnroll(enrollment);
    }

    @Override
    public int checkRegisEnroll(User user, Subject subject) {
        return enrollmentDAO.checkRegisEnroll(user, subject);
    }

    @Override
    public void removeEnrollment(User user, Subject subject) {
        enrollmentDAO.removeEnrollment(user, subject);
    }

    @Override
    public Map<String, Float> evaluateStudent(User user) {
        return enrollmentDAO.evaluateStudent(user);
    }
}
