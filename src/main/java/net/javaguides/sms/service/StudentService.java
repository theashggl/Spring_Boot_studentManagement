package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entitity.Student;

public interface StudentService {// Todo know about this in detail.
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student updateStudent(Student student);

    Student getStudentById(Long id);

    void deleteStudentById(Long id);
}
