package org.example.service;

import org.example.model.Enrollment;
import org.example.model.Subject;
import org.example.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public interface IEnrollmentService {
    Map<String, Object> getMyEnrollment(User user);

    boolean checkEnrollment(User user);

    void addEnroll(Enrollment enrollment);

    int checkRegisEnroll(User user, Subject subject);

    void removeEnrollment(User user, Subject subject);

    Map<String, Float> evaluateStudent(User user);
}
