package com.duong.service;

import java.sql.SQLException;
import java.util.List;

public interface IService<T> {
List<T> selectAll();
void insert(T t);
T getById (int id);
boolean delete (int id) throws SQLException;
}
