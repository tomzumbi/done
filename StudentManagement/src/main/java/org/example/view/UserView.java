package org.example.view;

import org.example.controller.UserController;
import org.example.model.User;

import java.util.Scanner;

public class UserView {
    Scanner scanner = new Scanner(System.in);
    UserController userController = new UserController();
    StudentView studentView = new StudentView();
    AdminView adminView = new AdminView();
    public void menuUserView() {
        while (true) {
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng kí");
            System.out.println("3. Quên mật khẩu");
            System.out.println("4. Thoát chương trình");
            System.out.print("Mời bạn nhập lựa chọn: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    User user = userController.login();
                    if (user != null) {
                        if (user.isRole()) {
                            System.out.println("");
                            studentView.menuStudentView(user);
                        } else {
                            adminView.menu(user);
                        }
                    } else {
                        break;
                    }
                    break;
                case "2":
                    userController.register();
                    break;
                case "3":
                    userController.forgotPassword();
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ!");
                    break;


            }


        }
    }


}
