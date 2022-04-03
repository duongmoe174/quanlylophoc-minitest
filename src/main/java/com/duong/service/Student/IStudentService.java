package com.duong.service.Student;

import com.duong.model.Student;
import com.duong.service.IService;

public interface IStudentService extends IService<Student> {
     void insertStudentToManyClasses (Student student, int [] classes);
}
