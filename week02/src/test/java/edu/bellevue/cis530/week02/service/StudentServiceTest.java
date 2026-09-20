package edu.bellevue.cis530.week02.service;

import edu.bellevue.cis530.week02.exception.StudentNotFoundException;
import edu.bellevue.cis530.week02.model.Student;
import edu.bellevue.cis530.week02.repository.StudentRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentServiceTest {

    @Test
    void findByIdThrowsWhenStudentNotFound() {
        StudentRepository repository = new StudentRepository();
        StudentService service = new StudentService(repository);

        StudentNotFoundException exception = assertThrows(
                StudentNotFoundException.class,
                () -> service.findById(99L)
        );

        assertEquals("Student with id 99 not found", exception.getMessage());
    }

    @Test
    void saveAndFindByIdWorks() {
        StudentRepository repository = new StudentRepository();
        StudentService service = new StudentService(repository);

        Student student = service.save(new Student(null, "Alice", "Jones", "alice@example.com", "CIS530", "Fall 2026"));

        assertEquals("Alice", service.findById(student.getId()).getFirstName());
    }
}
