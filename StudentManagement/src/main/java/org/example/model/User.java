package org.example.model;


import java.sql.Date;
import java.util.List;

public class User {
    private String idUser;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private Date birthday;
    private String address;
    private String gender;
    // 1: đang hoc 2: nghỉ học 3: thôi học
    private int status;
    private boolean role;
    private List <Enrollment> enrollments;

    public User(String idUser, String username, String password, String name, String email, String phone, Date birthday, String address, String gender, int status, boolean role, List<Enrollment> enrollments) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
        this.gender = gender;
        this.status = status;
        this.role = role;
        this.enrollments = enrollments;
    }

    public User(String idUser, String username, String password, String name, String email, String phone, Date birthday, String address, int status, boolean role, String gender) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
        this.status = status;
        this.role = role;
        this.gender = gender;
    }

    public User(String idUser, String username, String password, String name, String email, String phone, Date birthday, String address,String gender) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
        this.gender = gender;
    }


    public User(String idUser, String username, String password,  String email, String phone, String gender,int status, boolean role) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.status = status;
        this.role = role;
    }



    public User() {
    }
    public User(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isRole() {
        return role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    @Override
    public String toString() {
        return String.format("+------------+---------------------+---------------------------------+-----------------+------------+---------------------+---------------------------------------------------------+\n" +
                             "| %-10s | %-19s | %-31s | %-15s | %-10s | %-19s | %-55s |\n",
                                idUser, name, email, phone, gender, birthday, address);
    }
}
