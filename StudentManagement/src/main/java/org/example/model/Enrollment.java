package org.example.model;

import java.sql.Date;

public class Enrollment {
    private String idUser;
    private String idSubject;
    private Date enrollmentDate;
    private float avgScore;

    public Enrollment(String idUser, String idSubject, Date enrollmentDate, float avgScore) {
        this.idUser = idUser;
        this.idSubject = idSubject;
        this.enrollmentDate = enrollmentDate;
        this.avgScore = avgScore;
    }

    public Enrollment(String idUser, String idSubject, float avgScore) {
        this.idUser = idUser;
        this.idSubject = idSubject;
        this.avgScore = avgScore;
    }

    public Enrollment(String idUser, String idSubject, Date enrollmentDate) {
        this.idUser = idUser;
        this.idSubject = idSubject;
        this.enrollmentDate = enrollmentDate;
    }

    public Enrollment() {
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }
}
