package org.example.service.impl;

import org.example.DAO.SubjectDAO.SubjectDAO;
import org.example.model.Subject;
import org.example.service.ISubjectService;

import java.util.List;

public class SubjectService implements ISubjectService {
    SubjectDAO dao = new SubjectDAO();
    @Override
    public List<Subject> selectAll() {
        return dao.selectAll();
    }

    @Override
    public Subject findByName(String subjectName) {
        return dao.findByName(subjectName);
    }
}
