package org.example.controller;

import org.example.model.Subject;
import org.example.service.impl.SubjectService;

import java.util.ArrayList;
import java.util.List;

public class SubjectController {
    SubjectService subjectService = new SubjectService();
    public void getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        subjects = subjectService.selectAll();
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

    public Subject findByName(String subjectName) {
        if (subjectService.findByName(subjectName) != null) {
            return subjectService.findByName(subjectName);
        } else {
            return null;
        }
    }
}
