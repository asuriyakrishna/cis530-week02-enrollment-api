package edu.bellevue.cis530.week02.repository;

import edu.bellevue.cis530.week02.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StudentRepository {

    private final Map<Long, Student> students = new HashMap<>();
    private Long nextId = 1L;

    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    public Optional<Student> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(students.get(id));
    }

    public Student save(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        Long id = student.getId();
        if (id == null) {
            id = nextId++;
            student.setId(id);
        }

        students.put(id, student);
        return student;
    }

    public Student update(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        Long id = student.getId();
        if (id == null || !students.containsKey(id)) {
            throw new IllegalArgumentException("Student not found for update");
        }

        students.put(id, student);
        return student;
    }

    public void delete(Long id) {
        if (id != null) {
            students.remove(id);
        }
    }
}
