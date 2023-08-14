package net.javaguides.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.sms.entitity.Student;
import net.javaguides.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {// This method is to run on a new thread instance and serves as
                                                      // the first method to run inside that thread instance. Can be
                                                      // used to initialize objects that helps stave off of nullpointer
                                                      // exception.
        // It is some logic to save data on run of application
        // Student student1 = new Student("Ramesh", "Fadatare", "ramesh@gmail.com");
        // studentRepository.save(student1);
        // Student student2 = new Student("Sanjay", "Jadhav", "sanjay@gmail.com");
        // studentRepository.save(student2);
        // Student student3 = new Student("Tony", "Stark", "tony@gmail.com");
        // studentRepository.save(student3);

    }

}
