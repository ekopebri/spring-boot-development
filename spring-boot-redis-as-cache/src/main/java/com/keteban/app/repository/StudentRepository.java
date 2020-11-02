package com.keteban.app.repository;

import com.keteban.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author EPebrisulistiyo
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
    
}
