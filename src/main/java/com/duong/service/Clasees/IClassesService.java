package com.duong.service.clasees;

import com.duong.model.Classes;
import com.duong.service.IService;

import java.util.List;

public interface IClassesService extends IService<Classes> {
    List<Classes> selectAllByClassesId (int classes_id);
}
