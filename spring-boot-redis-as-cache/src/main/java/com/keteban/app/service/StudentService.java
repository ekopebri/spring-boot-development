package com.keteban.app.service;

import com.keteban.app.entity.Student;
import com.keteban.app.error.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.keteban.app.repository.StudentRepository;

/**
 *
 * @author EPebrisulistiyo
 */
@Service
public class StudentService implements IStudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student arg0) {
        return studentRepository.save(arg0);
    }

    @Override
    @CachePut(value = "students", key= "#arg0") //value adalah nama table, key adalah parameter key kita
    public Student update(Integer arg0, Student arg1) {
        Student student = studentRepository.findById(arg0)
                .orElseThrow(() -> new ResourceNotFoundException("Student Not Exist"));
        student.setName(arg1.getName());
        student.setEmail(arg1.getEmail());
        return studentRepository.save(student);
    }

    @Override
    @CacheEvict(value = "students", key= "#arg0")//allEntries = true) //value adalah nama table, key adalah parameter key kita
    public void delete(Integer arg0) {
        Student student = studentRepository.findById(arg0)
                .orElseThrow(() -> new ResourceNotFoundException("Student Not Found"));
        studentRepository.delete(student);
    }

    @Override
    @Cacheable(value = "students", key= "#arg0") //value adalah nama table, key adalah parameter key kita
    public Student getById(Integer arg0) {
        Student student = studentRepository.findById(arg0)
                .orElseThrow(() -> new ResourceNotFoundException("Student Not Found"));
        return student;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
    
}
