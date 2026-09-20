package edu.bellevue.cis530.week02.service;

import edu.bellevue.cis530.week02.exception.StudentNotFoundException;
import edu.bellevue.cis530.week02.model.Student;
import edu.bellevue.cis530.week02.repository.StudentRepository;

import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student update(Student student) {
        Student existingStudent = studentRepository.findById(student.getId())
                .orElseThrow(() -> new StudentNotFoundException(student.getId()));

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setCourseCode(student.getCourseCode());
        existingStudent.setSemester(student.getSemester());

        return studentRepository.update(existingStudent);
    }

    public void delete(Long id) {
        if (studentRepository.findById(id).isEmpty()) {
            throw new StudentNotFoundException(id);
        }
        studentRepository.delete(id);
    }
}
