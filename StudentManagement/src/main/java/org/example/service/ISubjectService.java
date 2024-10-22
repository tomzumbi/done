package org.example.service;

import org.example.model.Subject;

import java.util.List;

public interface ISubjectService {
     List<Subject> selectAll();
     Subject findByName(String subjectName);
}
