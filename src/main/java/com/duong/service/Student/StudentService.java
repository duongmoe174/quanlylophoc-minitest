package com.duong.service.Student;

import com.duong.model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService implements IStudentService{
    @Override
    public List<Student> selectAll() {
        return null;
    }

    @Override
    public void insert(Student student) {
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

    @Override
    public void insertStudentToManyClasses(Student student, int[] classes) {

    }
}
