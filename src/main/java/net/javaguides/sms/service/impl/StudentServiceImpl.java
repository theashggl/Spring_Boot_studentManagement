package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import net.javaguides.sms.entitity.Student;
import net.javaguides.sms.repository.StudentRepository;
import net.javaguides.sms.service.StudentService;

@Service // This annotation denotes that the class will responsible for doing something,
         // i.e., this will be one of the classes which will be responsible for the
         // backend functions
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();// Using get method of optional class to get the value as findById
                                                    // method returns optional class object.
    }

    @Override
    public void deleteStudentById(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

}
