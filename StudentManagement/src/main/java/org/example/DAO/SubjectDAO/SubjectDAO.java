package org.example.DAO.SubjectDAO;

import org.example.DAO.ConnectionMySql;
import org.example.model.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO {
    private Connection connection = ConnectionMySql.getConnection();

    public List<Subject> selectAll() {
        List<Subject> subjects = new ArrayList<Subject>();
        String sql = "select * from subject";
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()){
                String idSubject = resultSet.getString("idSubject");
                String subjectName = resultSet.getString("subjectname");
                int credit = resultSet.getInt("credit");
                subjects.add(new Subject(idSubject, subjectName, credit));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjects;
    }

    public Subject findByName(String subjectName) {
        String sql = "SELECT * FROM subject WHERE subjectname COLLATE utf8mb4_general_ci = ?" ;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, subjectName);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String idSubject = resultSet.getString("idSubject");
            String name = resultSet.getString("subjectname");
            String credit = resultSet.getString("credit");
            return new Subject(idSubject, name, Integer.parseInt(credit));
        } catch (SQLException e) {
            return null;
        }
    }

}
