package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Exception.StudentNotFoundException;
import com.example.demo.Model.Student;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    // Register student
    public Student registerStudent(Student student) {
        students.add(student);
        return student;
    }

    // View all students
    public List<Student> getAllStudents() {
        return students;
    }

    // Find student by ID
    public Student getStudentById(int id) {

        for (Student student : students) {

            if (student.getStudentId() == id) {
                return student;
            }
        }

        throw new StudentNotFoundException(
                "Student not found with ID: " + id);
    }
    
    //updating the students
    public String updateStudent(int id,Student update)
    {
   	 for(Student student:students)
   	 {
   		 if(student.getStudentId()==id)
   		 {
   			 student.setStudentId(update.getStudentId());
   			 student.setStudentName(update.getStudentName());
   			 student.setCourseName(update.getCourseName());
   			 student.setEmail(update.getEmail());
   			 student.setAge(update.getAge());
   			 
   			 return"Student details updated successfully";
   		 }
   	 }
   	 return"Student not found";
    }

    // Delete registration
    public String deleteStudent(int id) {

        for (Student student : students) {

            if (student.getStudentId() == id) {
                students.remove(student);
                return "Student registration deleted successfully";
            }
        }

        throw new StudentNotFoundException(
                "Student not found with ID: " + id);
    }
}
