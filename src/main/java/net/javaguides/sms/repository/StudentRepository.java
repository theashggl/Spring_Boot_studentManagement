package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.sms.entitity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {// seems like it si createed to use jpa methods

}
