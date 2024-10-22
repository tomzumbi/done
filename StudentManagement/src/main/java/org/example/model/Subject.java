package org.example.model;

public class Subject {
    private String idSubject;
    private String subjectName;
    //tín chỉ
    private int credit;

    public Subject(String idSubject, String subjectName, int credit) {
        this.idSubject = idSubject;
        this.subjectName = subjectName;
        this.credit = credit;
    }

    public Subject() {
    }

    public String getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
