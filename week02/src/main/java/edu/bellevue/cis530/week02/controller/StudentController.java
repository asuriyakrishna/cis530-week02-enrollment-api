package edu.bellevue.cis530.week02.controller;

import edu.bellevue.cis530.week02.exception.StudentNotFoundException;
import edu.bellevue.cis530.week02.model.Student;
import edu.bellevue.cis530.week02.repository.StudentRepository;
import edu.bellevue.cis530.week02.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController() {
        this.studentService = new StudentService(new StudentRepository());
    }

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        List<Student> students = studentService.findAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        Student student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        if (student == null) {
            return ResponseEntity.badRequest().body("Student payload is required");
        }

        Student createdStudent = studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        if (student == null) {
            return ResponseEntity.badRequest().body("Student payload is required");
        }

        student.setId(id);
        Student updatedStudent = studentService.update(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
