package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entitity.Student;
import net.javaguides.sms.service.StudentService;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // handler method to handle list students and return mode and view
    @GetMapping("/students")
    public String listStudent(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";// This will be the html file name that will be used to show the webpage
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student)// The ModelAttribute will fill data in the
                                                                         // student model attribute from a form that was
                                                                         // submitted in the previous page
    {
        studentService.saveStudent(student);
        return "redirect:/students";
    }
}
