package com.duong.service.student;

import com.duong.config.ConnectionJDBC;
import com.duong.model.Classes;
import com.duong.model.Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService{
    Connection connection = ConnectionJDBC.getConnect();
    @Override
    public List<Student> selectAll() {
        List<Student> students = new ArrayList<>();
        String query = "{CALL selectAllStudent()}";
        try {
            CallableStatement callableStatement = connection.prepareCall(query);
            ResultSet resultSet= callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String address = resultSet.getString("stu_address");
                int id_class = resultSet.getInt("class_id");
                String className = resultSet.getString("class_name");
                Classes classes = new Classes(id_class, className);
                Student student = new Student(id, firstname, lastname, address, classes);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void insert(Student student) {
        String query = "{CALL insertNewStudent(?,?,?,?)}";
        try (CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setString(1, student.getFirstname());
            callableStatement.setString(2, student.getLastname());
            callableStatement.setString(3, student.getAddress());
            callableStatement.setInt(4, student.getClasses().getId());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Student student) throws SQLException {
        return false;
    }
}
