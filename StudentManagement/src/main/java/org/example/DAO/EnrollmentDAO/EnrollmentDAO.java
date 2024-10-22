package org.example.DAO.EnrollmentDAO;

import org.example.DAO.ConnectionMySql;
import org.example.model.Enrollment;
import org.example.model.Subject;
import org.example.model.User;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class EnrollmentDAO {
    private Connection connection = ConnectionMySql.getConnection();

    public boolean checkEnrollment(User user) {
        String sql = "select count(*) from enrollment where idUser = " + user.getIdUser();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public Map <String, Object> getMyEnrollment(User user) {
        Map <String, Object> map = new HashMap<>();
        String sql = "select subjectname,enrollmentDate from enrollment INNER JOIN subject on enrollment.idSubject = subject.idSubject where idUser = " + user.getIdUser();
        try{
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()){
                String subjectName = resultSet.getString("subjectname");
                Date dateEnroll = resultSet.getDate("enrollmentDate");
                map.put(subjectName, dateEnroll);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public void addEnroll(Enrollment enrollment) {
        String sql = "insert into enrollment (idUser, idSubject, enrollmentDate) values (?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,enrollment.getIdUser());
            preparedStatement.setString(2,enrollment.getIdSubject());
            preparedStatement.setDate(3,enrollment.getEnrollmentDate());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int checkRegisEnroll(User user, Subject subject) {
        String sql = "select count(*) from enrollment where idSubject = ? and idUser =  ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,subject.getIdSubject());
            ps.setString(2,user.getIdUser());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                int count = rs.getInt(1);
                return count;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void removeEnrollment(User user, Subject subject) {
        String sql = "delete from enrollment where idUser = ? and idSubject COLLATE utf8mb4_general_ci = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getIdUser());
            preparedStatement.setString(2,subject.getIdSubject());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Map <String, Float> evaluateStudent(User user) {
        Map <String, Float> map = new HashMap<>();
        String sql = "select * from enrollment INNER JOIN subject on enrollment.idSubject = subject.idSubject where idUser = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getIdUser());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String subjectName = resultSet.getString("subjectname");
                float avgScore = resultSet.getFloat("avgScore");
                map.put(subjectName, avgScore);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }


}
