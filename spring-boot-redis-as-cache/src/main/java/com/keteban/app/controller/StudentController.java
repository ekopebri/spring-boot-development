package com.keteban.app.controller;

import com.keteban.app.entity.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.keteban.app.service.IStudentService;

/**
 *
 * @author EPebrisulistiyo
 */
@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    IStudentService employeeService;
    
    @PostMapping("/employee")
    public Student saveEmployee(@RequestBody Student employee) {
        return employeeService.save(employee);
    }
    
    @GetMapping("employees")
    public ResponseEntity<List<Student>> getEmployees() {
        return ResponseEntity.ok(employeeService.getAll());
    }
    
    @PutMapping("/employee/{id}")
    public Student updateEmployee(@PathVariable("id") Integer id, @RequestBody Student employee) {
        return employeeService.update(id, employee);
    }
    
    @GetMapping("/employee/{id}")
    public Student getEmployee(@PathVariable("id") Integer id) {
        return employeeService.getById(id);
    }
    
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.delete(id);
        return "Employee Deleted " + id;
    }
}
