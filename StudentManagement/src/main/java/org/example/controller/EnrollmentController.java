package org.example.controller;

import org.example.model.Enrollment;
import org.example.model.Subject;
import org.example.model.User;
import org.example.service.impl.EnrollmentService;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class EnrollmentController {
    EnrollmentService enrollmentService = new EnrollmentService();

    public void getEnrollment(User user) {
        Map<String, Object> enrollments = new HashMap<>();
        enrollments = enrollmentService.getMyEnrollment(user);
        System.out.format("%-20s %-20s%n", "Tên học phần", "Ngày đăng ký");
        System.out.println("-------------------- --------------------");
        for (Map.Entry<String, Object> entry : enrollments.entrySet()) {
            String courseName = entry.getKey(); // Tên học phần
            String registrationDate = entry.getValue().toString(); // Ngày đăng ký (giả sử là String)
            System.out.format("%-20s %-20s%n", courseName, registrationDate);
        }
    }

    public boolean checkEnrollment(User user) {
        if (enrollmentService.checkEnrollment(user)) {
            return true;
        } else {
            return false;
        }
    }

    public void addEnrollment(User user, Subject subject) {
        Enrollment enrollment = new Enrollment();
        enrollment.setIdUser(user.getIdUser());
        enrollment.setIdSubject(subject.getIdSubject());
        Date date = new Date(System.currentTimeMillis());
        enrollment.setEnrollmentDate(date);
        enrollmentService.addEnroll(enrollment);

    }


    public int checkRegisEnroll(User user, Subject subject){
        return enrollmentService.checkRegisEnroll(user, subject);
    }

    public void removeEnrollment(User user, Subject subject){
        enrollmentService.removeEnrollment(user, subject);
    }

    public Map <String, Float> evaluateStudent(User user) {
       Map <String, Float> enrolls = new HashMap<>();
       enrolls = enrollmentService.evaluateStudent(user);
        System.out.printf("%-20s %-10s %-10s%n", "Tên học phần", "Điểm", "Xếp loại");
        System.out.println("-----------------------------------------");
       for (Map.Entry<String, Float> entry : enrolls.entrySet()) {
           String ranking = ""; // học lực
           String courseName = entry.getKey();
           Float score = entry.getValue();
            if (score >= 8){
                ranking = "Giỏi";
            } else if (score >= 7){
                ranking = "Khá";
            } else if (score >= 5){
                ranking = "Trung bình";
            } else {
                ranking = "Yếu";
            }

           System.out.printf("%-20s %-10.2f %-10s%n", courseName, score, ranking);
       }
       return enrolls;
    }


}
