package org.example.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    private static final String PHONE_REGEX = "^(0[1-9]{1}[0-9]{8})$";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public static boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public  boolean isValidDay(String day) {
        try {
            int d = Integer.parseInt(day);
            return d >= 1 && d <= 31;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isValidMonth(String month) {
        try {
            int m = Integer.parseInt(month);
            return m >= 1 && m <= 12;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isValidYear(String year) {
        try {
            int y = Integer.parseInt(year);
            int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
            return y > 1000 && y <= currentYear;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidStudentID(String studentID) {
        String regex = "^177\\d{7,}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(studentID).matches();
    }


}
