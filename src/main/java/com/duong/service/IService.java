package com.duong.service;

import java.util.List;

public interface IService<T> {
List<T> selectAll();
void insert(T t);
T getById (int id);
}
