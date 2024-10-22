package org.example.view;

import org.example.controller.EnrollmentController;
import org.example.controller.StudentController;
import org.example.controller.SubjectController;
import org.example.model.Subject;
import org.example.model.User;

import java.util.Scanner;

public class StudentView {
    Scanner sc = new Scanner(System.in);
    StudentController controller = new StudentController();
    SubjectController subjectController = new SubjectController();
    EnrollmentController enrollmentController = new EnrollmentController();

    public void menuStudentView(User user) {
        System.out.println("Xin chào sinh viên: " + user.getName());
        while (true) {
            System.out.println("");
            System.out.println("1. Hiển thị thông tin sinh viên");
            System.out.println("2. Cập nhật thông tin");
            System.out.println("3. Sửa thông tin");
            System.out.println("4. Kiểm tra các học phần");
            System.out.println("5. Kiểm tra các học phần đã đăng kí");
            System.out.println("6. Đăng kí học phần");
            System.out.println("7. Hủy bỏ học phần đã đăng kí");
            System.out.println("8. Kiểm tra tình trạng học tập");
            System.out.println("9. Đăng xuất");
            System.out.print("Lựa chọn của bạn: ");
            String choice = sc.nextLine();
            System.out.println("");
            switch (choice) {
                case "1":
                    controller.getInformation(user);
                    break;
                case "2":
                    controller.updateInformation(user);
                    break;
                case "3":
                    editStudentView(user);
                    break;
                case "4":
                    subjectController.getAllSubjects();
                    break;
                case "5":
                    if (enrollmentController.checkEnrollment(user)) {
                        enrollmentController.getEnrollment(user);

                    } else {
                        System.out.println("Bạn chưa đăng kí học phần nào vui lòng đăng kí trước khi kiểm tra!");
                    }

                    break;
                case "6":
                    System.out.print("Nhập tên học phần bạn muốn đăng kí: ");
                    String subjectName = sc.nextLine();
                    Subject subject = subjectController.findByName(subjectName);
                    if (subject != null) {
                        if (enrollmentController.checkRegisEnroll(user, subject) > 0) {
                            System.out.println("Bạn đã đăng kí học phần này vui lòng kiểm tra các học phần khác!");
                        } else {
                            enrollmentController.addEnrollment(user, subject);
                            System.out.println("Bạn đã đăng kí học phần " + subject.getSubjectName() + " thành công!");
                        }
                    } else {
                        System.out.println("Học phần không tồn tại vui lòng kiểm tra lại!");
                    }
                    break;
                case "7":
                    System.out.print("Nhập tên học phần bạn muốn hủy đăng kí: ");
                    String subjectName1 = sc.nextLine();
                    Subject subject1 = subjectController.findByName(subjectName1);
                    if (subject1 != null) {
                        if (enrollmentController.checkRegisEnroll(user, subject1) == 0) {
                            System.out.println("Bạn chưa đăng kí học phần này!");
                        }else {
                            enrollmentController.removeEnrollment(user, subject1);
                            System.out.println("Hủy đăng kí học phần " + subject1.getSubjectName() + " thành công! Mã học phần: " + subject1.getIdSubject());
                        }
                    } else {
                        System.out.println("Không tồn tại học phần có tên: " + subjectName1 + " . Vui lòng kiểm tra lại!");
                    }

                    break;
                case "8":
                    enrollmentController.evaluateStudent(user);
                    break;
                case "9":
                    UserView userView = new UserView();
                    userView.menuUserView();
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ!");
                    break;
            }
        }
    }


    public void editStudentView(User user) {
        System.out.println("");
        System.out.println("Bạn muốn sửa: ");
        while (true) {
            System.out.println("1. Số điện thoại");
            System.out.println("2. Email");
            System.out.println("3. Quay lại");
            System.out.print("Lựa chọn của bạn: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    controller.editPhone(user);
                    break;
                case "2":
                    controller.editEmail(user);
                    break;
                case "3":
                    menuStudentView(user);
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ");
                    break;
            }
        }
    }

}
