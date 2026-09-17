package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // Register student
    @PostMapping("/add")
    public Student registerStudent(
            @Valid @RequestBody Student student) {

        return service.registerStudent(student);
    }

    // View all students
    @GetMapping("/getstu")
    public List<Student> getAllStudents() {

        return service.getAllStudents();
    }

    // Find student by ID
    @GetMapping("/{id}")
    public Student getStudentById(
            @PathVariable int id) {

        return service.getStudentById(id);
    }

    //updating the student
    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody  Student update)
    {
    	return service.updateStudent(id,update);
    }
  
    // Delete registration
    @DeleteMapping("/{id}")
    public String deleteStudent(
            @PathVariable int id) {

        return service.deleteStudent(id);
    }
}