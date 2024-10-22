package org.example.config;

import java.util.regex.Pattern;

public class AdminConfig {
    //Ngày tháng
    public boolean isValiDate(int day, int month, int year) {
        if (year < 1990 || year > 2024) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        int daysInFebruary = isLeapYear(year) ? 29 : 28;
        int[] dayInMonth = {31, daysInFebruary , 31, 30, 31, 30, 31, 31, 30, 31,30, 31};
        return day > 0 && day <= dayInMonth[month - 1];
    }
    //Năm
    public boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    //Email
    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$"; // Định dạng cơ bản cho địa chỉ email
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
    public boolean isValidPhoneNumber(String phoneNumber) {
        // Biểu thức chính quy cho số điện thoại Việt Nam, đúng 10 chữ số bắt đầu bằng 0
        String phoneRegex = "^0[3|5|7|8|9][0-9]{8}$"; // Đầu số 0 và phải theo sau bởi 9 chữ số, với các đầu số hợp lệ
        Pattern pattern = Pattern.compile(phoneRegex);
        return pattern.matcher(phoneNumber).matches();
    }
    //Trạng thai
    public boolean isValidStatus(int status) {
        int[] validStatuses = {1, 2, 3, 3};
        for (int validStatus : validStatuses) {
            if (validStatus == status) {
                return true;
            }
        }
        return false;
    }
    public boolean containsInvalidCharacters(String str) {
        return !str.matches("[a-zA-ZÀ-ỹà-ỹ\\s]+");
    }
    //Phương thức đánh giá điểm của học sinh
    public String evaluateScore(Integer score) {
        if (score >= 8) {
            return "Giỏi";
        } else if (score >= 6.5) {
            return "Khá";
        } else if (score >= 5) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }
}

