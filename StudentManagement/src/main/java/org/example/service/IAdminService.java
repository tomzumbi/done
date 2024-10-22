package org.example.service;

import org.example.model.Subject;
import org.example.model.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IAdminService {
    void deleteStudent(String idUser);

    User findUserByID(String idUser);

    boolean updateStudentDateOfBirth(User user);

    boolean updateEmailStudent(User user);

    boolean updateStudentPhone(User user);

    boolean updateStatus(User user);

    List<User> studentList();

    void findStudent(String idUser);

    boolean updateCreditSubject(Subject subject);

    boolean updateNameSubject(Subject subject);

    Subject findSubjectByID(String subjectId);

    Map<String, List<Map<String, Object>>> getStudentsWithClassification();

    List<Subject> selectAll();

    List<User> getUserNotID();

    User findByEmail(String email);

    boolean updateStudentID(User user);
    boolean checkID(String idUser);
    List<User> academicRecords();

}
