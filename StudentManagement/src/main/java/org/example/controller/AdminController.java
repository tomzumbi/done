package org.example.controller;

import org.example.config.AdminConfig;
import org.example.config.Validate;
import org.example.model.Enrollment;
import org.example.model.Subject;
import org.example.model.User;
import org.example.service.impl.AdminService;
import org.example.service.impl.StudentService;
import org.example.service.impl.SubjectService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdminController {
    AdminService adminService = new AdminService();
    AdminConfig adminConfig = new AdminConfig();
    Scanner scanner = new Scanner(System.in);
    SubjectService subjectService = new SubjectService();

    //Sửa tín chỉ
    public void updateCreditSubject() {
        Subject subject;
        String idSubject;
        AdminConfig adminConfig = new AdminConfig();
        while (true) {
            System.out.print("Nhập ID: ");
            idSubject = scanner.nextLine();
            subject = adminService.findSubjectByID(idSubject);

            if (subject != null) {
                break;
            } else {
                System.out.println("ID không hợp lệ. Không tìm thấy môn học với ID: " + idSubject + ". Vui lòng nhập lại.");
            }
        }
        while (true) {
            if (subject != null) {
                System.out.print("Nhập số tín chỉ mới: ");
                if (scanner.hasNextInt()) {
                    int credit = scanner.nextInt();
                    subject.setCredit(credit);
                    boolean isUpdated = adminService.updateCreditSubject(subject);
                    if (isUpdated) {
                        System.out.println("Cập nhật tín chỉ thành công.");
                    } else {
                        System.out.println("Cập nhật tín chỉ không thành công.");
                    }
                    break;
                } else {
                    System.out.println("Vui lòng nhập một số nguyên hợp lệ (không được nhập ký tự chữ).");
                    scanner.next();
                }
            }
        }
    }

    //Sửa tên môn học
    public void updateNameSubject() {
        Subject subject;
        String idSubject;
        AdminConfig adminException = new AdminConfig();
        while (true) {
            System.out.print("Nhập ID: ");
            idSubject = scanner.nextLine();
            subject = adminService.findSubjectByID(idSubject);
            if (subject != null) {
                break;
            } else {
                System.out.println("ID không hợp lệ. Không tìm thấy môn học với ID: " + idSubject + ". Vui lòng nhập lại.");
            }
        }
        while (true) {
            if (subject != null) {
                System.out.print("Nhập tên môn học mới: ");
                String name = scanner.nextLine();
                if (adminException.containsInvalidCharacters(name)) {
                    System.out.println("Vui lòng chỉ nhập ký tự chữ (không chứa số hoặc ký tự đặc biệt).");
                } else {
                    subject.setSubjectName(name);
                    boolean isUpdated = adminService.updateNameSubject(subject);
                    if (isUpdated) {
                        System.out.println("Cập nhật tên môn học thành công.");

                    } else {
                        System.out.println("Cập nhật tên môn học không thành công.");
                    }
                    break;
                }
            }
        }
    }

    // Phương thức hiển thị danh sách học sinh theo phân loại
    public void displayStudentsByClassification() {
        Map<String, List<Map<String, Object>>> studentsByClassification = adminService.getStudentsWithClassification();
        if (studentsByClassification != null) {
            // In tiêu đề bảng
            System.out.printf("%-10s %-20s %-10s %-15s%n", "ID", "Tên", "Điểm", "Đánh giá");

            for (String classification : studentsByClassification.keySet()) {
                for (Map<String, Object> student : studentsByClassification.get(classification)) {
                    Integer avgScore = (Integer) student.get("avgScore"); // Giả định điểm số là Integer
                    String evaluation = adminConfig.evaluateScore(avgScore);

                    // In từng dòng thông tin của học sinh
                    System.out.printf("%-10s %-20s %-10s %-15s%n",
                            student.get("idUser"),
                            student.get("username"),
                            avgScore,
                            evaluation);
                }
            }
        }
    }

    //Sinh viên
    public boolean deleteStudent() {
        User user;
        String idUser;
        AdminConfig adminException = new AdminConfig();
        while (true) {
            System.out.print("Nhập ID: ");
            idUser = scanner.nextLine();

            user = adminService.findUserByID(idUser); // Giả định phương thức này tìm người dùng theo ID

            if (user != null) {
                break; // Thoát vòng lặp nếu tìm thấy người dùng
            } else {
                System.out.println("ID không hợp lệ. Không tìm thấy người dùng với ID: " + idUser + ". Vui lòng nhập lại.");
            }
        }
        if (user != null) {
            adminService.deleteStudent(user.getIdUser());
            System.out.println("Xoa thanh cong");
            return true;
        } else {
            System.out.println("Chưa xóa");
            return false;
        }
    }

    //Update ngày sinh
    public boolean updateStudentDateOfBirth() {
        User user;
        String idUser;
        AdminConfig adminException = new AdminConfig();
        while (true) {
            System.out.print("Nhập ID: ");
            idUser = scanner.nextLine();

            user = adminService.findUserByID(idUser); // Giả định phương thức này tìm người dùng theo ID

            if (user != null) {
                break; // Thoát vòng lặp nếu tìm thấy người dùng
            } else {
                System.out.println("ID không hợp lệ. Không tìm thấy người dùng với ID: " + idUser + ". Vui lòng nhập lại.");
            }
        }
        String day = "";
        String month = "";
        String year = "";
        if (user != null) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Nhập ngày sinh: ");
                    day = scanner.nextLine();
                    System.out.print("Nhập tháng: ");
                    month = scanner.nextLine();
                    System.out.print("Nhập năm: ");
                    year = scanner.nextLine();

                    int intDay = Integer.parseInt(day);
                    int intMonth = Integer.parseInt(month);
                    int intYear = Integer.parseInt(year);

                    if (adminException.isValiDate(intDay, intMonth, intYear)) {
                        validInput = true;
                    } else {
                        System.out.println("Ngày sinh không hợp lệ. Vui lòng nhập lại: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Giá trị nhập không phải là số vui lòng nhập lại.");
                } catch (Exception e) {
                    System.out.println("Lỗi: " + e.getMessage());
                }
            }

            String birthday = year + "-" + month + "-" + day;
            Date date = Date.valueOf(birthday);
            user.setBirthday(date);
            adminService.updateStudentDateOfBirth(user);
            System.out.println("Sửa thành công");

        } else {
            System.out.println("Không tìm thấy sinh viên có mã " + idUser);
        }
        return false;
    }

    //Hiên thị thông tin sinh viên
    public void displayStudent() {
        List<User> users = adminService.studentList();
        if (users != null && !users.isEmpty()) {
            System.out.print("+------------+---------------------+---------------------------------+-----------------+------------+---------------------+---------------------------------------------------------+\n");
            System.out.print("|    ID      |        Name         |             Email               |      Phone      |   Gender   |      Birthday       |                         Address                         |\n");
            for (User user : users) {
                System.out.print(user.toString());
            }
            System.out.print("+------------+---------------------+---------------------+---------------------+---------------------------------+-----------------+------------+---------------------+---------------------------------------------------------+--------+-------+\n");

        } else {
            System.out.println("Không có sinh viên nào.");
        }
    }

    //tìm kiêm sinh viên
    public void findStudent() {
        User user;
        String idUser;
        AdminConfig adminException = new AdminConfig();
        while (true) {
            System.out.print("Nhập ID: ");
            idUser = scanner.nextLine();
            user = adminService.findUserByID(idUser);
            if (user != null) {
                System.out.print("+------------+---------------------+---------------------+---------------------+---------------------------------+-----------------+------------+---------------------+---------------------------------------------------------+--------+-------+\n");
                System.out.print("|    ID      |       Username      |       Password      |        Name         |             Email               |      Phone      |   Gender   |      Birthday       |                         Address                         | Status | Role  |\n");
                System.out.print(user.toString());
                System.out.print("+------------+---------------------+---------------------+---------------------+---------------------------------+-----------------+------------+---------------------+---------------------------------------------------------+--------+-------+\n");
                break;
            } else {
                System.out.println("ID không hợp lệ. Không tìm thấy người dùng với ID: " + idUser + ". Vui lòng nhập lại.");
            }
        }
    }

    //Sửa email sinh viên
    public void updateEmail() {
        User user;
        String idUser;
        AdminConfig adminException = new AdminConfig();
        while (true) {
            System.out.print("Nhập ID: ");
            idUser = scanner.nextLine();

            user = adminService.findUserByID(idUser); // Giả định phương thức này tìm người dùng theo ID

            if (user != null) {
                break; // Thoát vòng lặp nếu tìm thấy người dùng
            } else {
                System.out.println("ID không hợp lệ. Không tìm thấy người dùng với ID: " + idUser + ". Vui lòng nhập lại.");
            }
        }

        if (user != null) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Nhập Email: ");
                    String email = scanner.nextLine();
                    if (!adminException.isValidEmail(email)) {
                        throw new IllegalArgumentException("Email không hợp lệ. Vui lòng nhập dúng định dạng.");
                    }
                    user.setEmail(email);
                    adminService.updateEmailStudent(user);
                    System.out.println("Sửa thành công.");
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            System.out.println("Không tìm tháy người dùng");
        }
    }

    //Sửa số điện thoại
    public void updatePhoneNumber() {
        User user;
        String idUser;
        AdminConfig adminException = new AdminConfig();
        while (true) {
            System.out.print("Nhập ID: ");
            idUser = scanner.nextLine();

            user = adminService.findUserByID(idUser); // Giả định phương thức này tìm người dùng theo ID

            if (user != null) {
                break; // Thoát vòng lặp nếu tìm thấy người dùng
            } else {
                System.out.println("ID không hợp lệ. Không tìm thấy người dùng với ID: " + idUser + ". Vui lòng nhập lại.");
            }
        }
        if (user != null) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Nhập số diện thoại mới: ");
                    String phoneNumber = scanner.nextLine();
                    if (!adminException.isValidPhoneNumber(phoneNumber)) {
                        throw new IllegalArgumentException("Số điện thoại không hợp lệ. Vui lòng nhập lai số điện thoại đúng định dạng (VD: 09xxxxxxxx).");

                    }
                    user.setPhone(phoneNumber);
                    adminService.updateStudentPhone(user);
                    System.out.println("Cập nhật số điện thoại thành công.");
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    //Sửa trạng thái
    public void updateStatusStudent() {
        User user;
        String idUser;
        AdminConfig adminException = new AdminConfig();
        while (true) {
            System.out.print("Nhập ID: ");
            idUser = scanner.nextLine();

            user = adminService.findUserByID(idUser);

            if (user != null) {
                break;
            } else {
                System.out.println("ID không hợp lệ. Không tìm thấy người dùng với ID: " + idUser + ". Vui lòng nhập lại.");
            }
        }
        while (true) {
            if (user != null) {
                try {
                    System.out.println("Nhập trạng thái mới của sinh viên: ");
                    System.out.println("1. Đang học");
                    System.out.println("2. Nghỉ học");
                    System.out.println("3. Đình chỉ");
                    System.out.println("4. Bảo lưu");
                    System.out.print("Nhập lựa chọn (0-4): ");
                    int choice = scanner.nextInt();

                    if (choice < 1 || choice > 4) {
                        throw new IllegalArgumentException("Trạng thái không hợp lệ. Vui lòng nhập lại.");
                    }
                    user.setStatus(choice);
                    boolean isUpdated = adminService.updateStatus(user);
                    if (isUpdated) {
                        System.out.println("Cập nhật trạng thái thành công.");
                    } else {
                        System.out.println("Cập nhật trạng thái không thành công");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Lỗi: " + e.getMessage());
                }
                break;
            }
        }
    }


    public void getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        subjects = adminService.selectAll();
        System.out.println("");
        System.out.println("Các học phần: ");
        printTable(subjects);
    }


    private void printTable(List<Subject> subjects) {
        // Định dạng chiều rộng cho các cột
        int[] columnWidths = {15, 25, 10}; // Chiều rộng cho từng cột

        // In tiêu đề
        System.out.printf("%-" + columnWidths[0] + "s", "Mã môn học");
        System.out.printf("%-" + columnWidths[1] + "s", "Tên môn học");
        System.out.printf("%-" + columnWidths[2] + "s", "Số tín chỉ");
        System.out.println();

        // In đường kẻ
        for (int width : columnWidths) {
            System.out.print("-".repeat(width));
        }
        System.out.println();

        // In dữ liệu
        for (Subject subject : subjects) {
            System.out.printf("%-" + columnWidths[0] + "s", subject.getIdSubject());
            System.out.printf("%-" + columnWidths[1] + "s", subject.getSubjectName());
            System.out.printf("%-" + columnWidths[2] + "s", subject.getCredit());
            System.out.println();
        }
    }

    public void getUserNotID() {
        List<User> users = adminService.getUserNotID();
        System.out.printf("%-20s %-15s %-15s %-25s %-15s%n", "Họ và tên", "Username", "Password", "Email", "Phone");
        System.out.println("-------------------------------------------------------------------------------------");
        for (User user : users) {
            System.out.printf("%-20s %-15s %-15s %-25s %-15s%n",
                    user.getName(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getPhone());
        }
    }

    public void updateUserNotID() {
        User user;
        String email;
        while (true) {
            System.out.print("Nhập email sinh viên bạn muốn cập nhật: ");
            email = scanner.nextLine();

            user = adminService.findByEmail(email); // Giả định phương thức này tìm người dùng theo ID

            if (user != null) {
                break; // Thoát vòng lặp nếu tìm thấy người dùng
            } else {
                System.out.println("Email không hợp lệ. Không tìm thấy người dùng với email: " + email + ". Vui lòng nhập lại.");
            }
        }
        System.out.print("Nhập mã sinh viên: ");
        String idUser = scanner.nextLine();
        while (adminService.checkID(idUser)) {
            System.out.print("Mã sinh viên đã tồn tại vui lòng nhập mã sinh viên khác: ");
            idUser = scanner.nextLine();
        }
        while (!Validate.isValidStudentID(idUser)) {
            System.out.print("Mã sinh viên không đúng định dạng vui lòng nhập lại: ");
            idUser = scanner.nextLine();
        }
        user.setIdUser(idUser);
        adminService.updateStudentID(user);
        System.out.println("Cập nhật thành công!");
    }

    public void academicRecords() {
        List<Subject> subjects = subjectService.selectAll(); // Lấy danh sách các môn học
        List<User> users = adminService.academicRecords(); // Lấy danh sách người dùng

        // In tiêu đề bảng
        System.out.printf("%-15s %-20s", "Mã Sinh Viên", "Tên Sinh Viên");
        for (Subject subject : subjects) {
            System.out.printf("%-25s", subject.getSubjectName()); // In tên môn học
        }
        System.out.println();

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");

        // In dữ liệu cho từng người dùng
        for (User user : users) {
            System.out.printf("%-15s %-20s", user.getIdUser(), user.getName()); // In mã và tên người dùng

            // Mảng để lưu điểm cho từng môn học
            Float[] scores = new Float[subjects.size()];

            // Khởi tạo mảng scores bằng null
            for (int i = 0; i < scores.length; i++) {
                scores[i] = null; // Mặc định là chưa đăng ký
            }

            // Gán điểm cho các môn học đã đăng ký
            for (Enrollment enrollment : user.getEnrollments()) {
                for (int i = 0; i < subjects.size(); i++) {
                    // So sánh idSubject của enrollment với idSubject của subject
                    if (enrollment.getIdSubject().equals(subjects.get(i).getIdSubject())) {
                        scores[i] = enrollment.getAvgScore(); // Gán điểm cho môn học tương ứng
                    }
                }
            }

            // In điểm cho từng môn học
            for (int i = 0; i < subjects.size(); i++) {
                if (scores[i] == null) {
                    System.out.printf("%-25s", "Chưa đăng ký"); // Chưa đăng ký môn học
                } else if (scores[i] == 0) {
                    System.out.printf("%-25s", "Chưa có điểm"); // Chưa có điểm
                } else {
                    System.out.printf("%-25.2f", scores[i]); // In điểm các môn học
                }
            }
            System.out.println(); // Xuống dòng sau khi in xong một người dùng
        }
    }

}

