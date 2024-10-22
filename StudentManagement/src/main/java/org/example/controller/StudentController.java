package org.example.controller;

import org.example.config.Validate;
import org.example.model.User;
import org.example.service.impl.StudentService;

import java.sql.Date;
import java.util.Scanner;

public class StudentController {
    StudentService studentService = new StudentService();
    Scanner scanner = new Scanner(System.in);
    Validate validate = new Validate();
    public boolean updateInformation(User user) {
        System.out.print("Nhập họ và tên của bạn: ");
        String name = scanner.nextLine();
//        System.out.print("Nhập ngày sinh của bạn: ");
//        String day = scanner.nextLine();
//        System.out.print("Nhập tháng sinh của bạn: ");
//        String month = scanner.nextLine();
//        System.out.print("Nhập năm sinh của bạn: ");
//        String year = scanner.nextLine();


        String day;
        while (true) {
            System.out.print("Nhập ngày sinh của bạn: ");
            day = scanner.nextLine();
            if (validate.isValidDay(day)) {
                break; // Thoát vòng lặp nếu ngày hợp lệ
            } else {
                System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
            }
        }

        String month;
        while (true) {
            System.out.print("Nhập tháng sinh của bạn: ");
            month = scanner.nextLine();
            if (validate.isValidMonth(month)) {
                break; // Thoát vòng lặp nếu tháng hợp lệ
            } else {
                System.out.println("Tháng không hợp lệ. Vui lòng nhập lại.");
            }
        }

        String year;
        while (true) {
            System.out.print("Nhập năm sinh của bạn: ");
            year = scanner.nextLine();
            if (validate.isValidYear(year)) {
                break; // Thoát vòng lặp nếu năm hợp lệ
            } else {
                System.out.println("Năm không hợp lệ. Vui lòng nhập lại.");
            }
        }

        String date = year + "-" + month + "-" + day;
        Date birthday = Date.valueOf(date);
        System.out.print("Nhập địa chỉ của bạn: ");
        String address = scanner.nextLine();
        user.setName(name);
        user.setBirthday(birthday);
        user.setAddress(address);
        studentService.updateInformation(user);
        return true;
    }

    public void getInformation(User user) {
        System.out.printf("%-15s %-20s %-15s %-10s %-30s %-15s %n",
                "Mã Sinh Viên", "Tên", "Ngày Sinh", "Giới Tính", "Email", "Số Điện Thoại");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-15s %-10s %-30s %-15s %n", user.getIdUser(), user.getName(), user.getBirthday(), user.getGender(), user.getEmail(), user.getPhone());
    }

    public boolean editEmail(User user) {
        System.out.print("Nhập email mới của bạn: ");
        String email = scanner.nextLine();
        while (!Validate.validateEmail(email)){
            System.out.print("Email của bạn không đúng định dạng vui lòng nhập lại");
        }
        while (studentService.checkEmail(email)) {
            System.out.print("Email đã tồn tại vui lòng chọn email khác: ");
            email = scanner.nextLine();
        }
        user.setEmail(email);
        studentService.editEmail(user);
        System.out.println("Sửa email thành công! ");
        return true;
    }
    public boolean editPhone(User user) {
        System.out.print("Nhập số điện thoại mới của bạn: ");
        String phone = scanner.nextLine();
        while (!Validate.validatePhoneNumber(phone)){
            System.out.print("Số điện thoại của bạn không đúng định dạng vui lòng nhập lại");
        }
        while (studentService.checkPhoneNumber(phone)) {
            System.out.print("Số điện thoại đã được sử dụng vui lòng nhập số khác: ");
            phone = scanner.nextLine();
        }

        user.setPhone(phone);
        studentService.editPhone(user);
        System.out.println("Sửa số điện thoại thành công! ");
        return true;
    }

}
