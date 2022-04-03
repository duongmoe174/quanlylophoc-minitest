package com.duong.service.Clasees;

import com.duong.config.ConnectionJDBC;
import com.duong.model.Classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassesService implements IClassesService {
    Connection connection = ConnectionJDBC.getConnect();

    @Override
    public List<Classes> selectAllByClassesId(int classes_id) {
        return null;
    }

    @Override
    public List<Classes> selectAll() {
        List<Classes> classesList = new ArrayList<>();
        String query = "{CALL selectAllClasses()}";
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");

                Classes classes = new Classes(id, name, description);
                classesList.add(classes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classesList;
    }

    @Override
    public void insert(Classes classes) {
        String query = "{CALL insertClasses(?,?)}";
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setString(1, classes.getName());
            callableStatement.setString(2, classes.getDescription());
            System.out.println(callableStatement);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Classes getById(int id) {
        Classes classes = null;
        String query = "{CALL getClassesById (?)}";
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                classes = new Classes(name, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }
}
