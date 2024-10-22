package org.example.view;


import org.example.controller.AdminController;
import org.example.model.User;

import java.util.Scanner;

public class AdminView {
    Scanner sc = new Scanner(System.in);
    AdminController adminController = new AdminController();

    public void menu(User user) {
        while (true) {
            System.out.println("-----Menu----");
            System.out.println("1. Xóa sinh viên");
            System.out.println("2. Sửa thông tin sinh viên.");
            System.out.println("3. Tìm Kiếm sinh viên.");
            System.out.println("4. Thêm, sửa xóa học phần. ");
            System.out.println("5. Phân tích kết quả học tập của sinh viên.");
            System.out.println("6. Hiện thị danh sách sinh viên.");
            System.out.println("7. Hiện thị danh sách sinh viên chưa có mã sinh viên.");
            System.out.println("8. Cập nhập mã sinh viên.");
            System.out.println("9. Hiện thị danh sách học phần");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    //Xóa sinh viên
                    adminController.deleteStudent();
                    break;
                case "2":
                    String choice1 = "";
                    editMenuStudent(choice1, user);
                    sc.nextLine();
                    break;
                case "3":
                    adminController.findStudent();
                    break;
                case "4":
                    String choice2 = "";
                    editMenuSubject(choice2, user);
                    sc.nextLine();
                    break;
                case "5":
                    adminController.academicRecords();
                    break;
                case "6":
                    adminController.displayStudent();
                    break;
                case "7":
                    adminController.getUserNotID();
                    break;
                case "8":
                    adminController.updateUserNotID();
                    break;

                case "9":
                    adminController.getAllSubjects();

                    break;
                case "0":
                    UserView userView = new UserView();
                    userView.menuUserView();
                    break;
                default:
                    System.out.println("Không có chức năng mà bạn đã chọn");
            }
        }
    }

    // người dùng
    public void editMenuStudent(String choice, User user) {
        while (true) {
            System.out.println("-----Menu----");
            System.out.println("1. Sửa ngày sinh.");
            System.out.println("2. Địa chỉ.");
            System.out.println("3. Trạng thái.");
            System.out.println("4. Sửa email.");
            System.out.println("5. Sửa số điện thoại");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    adminController.updateStudentDateOfBirth();
                    break;
                case "2":
                    adminController.updateStudentDateOfBirth();
                    break;
                case "3":
                    adminController.updateStatusStudent();
                    break;
                case "4":
                    adminController.updateEmail();
                    break;
                case "5":
                    adminController.updatePhoneNumber();
                case "0":
                    menu(user);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! ");
                    break;
            }
        }
    }

    //Môn học
    public void editMenuSubject(String choice, User user) {
        while (true) {
            System.out.println("-----Menu----");
            System.out.println("1. Sửa tên môn học.");
            System.out.println("2. Sửa số tín chỉ.");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    adminController.updateNameSubject();
                    break;
                case "2":
                    adminController.updateCreditSubject();
                    break;
                case "0":
                    menu(user);
                default:
                    System.out.println("Lựa chọn không hợp lệ! ");
                    break;
            }
        }
    }
}
