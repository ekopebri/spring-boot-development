package com.keteban.app.service;

import com.keteban.app.entity.Student;
import java.util.List;

/**
 *
 * @author EPebrisulistiyo
 */
public interface IStudentService {
    Student save(Student e);
    Student update(Integer id, Student e);
    void delete(Integer id);
    
    Student getById(Integer id);
    List<Student> getAll();
}
