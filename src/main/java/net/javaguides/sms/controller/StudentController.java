package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entitity.Student;
import net.javaguides.sms.service.StudentService;

@Controller // This annotation is used to mark a class as a web request handler.
public class StudentController {// This class contains all the methods which are responsible for the http
                                // requests processing which
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // handler method to handle list students and return mode and view
    @GetMapping("/students") // Annotation to declare this method as a get request for the url path in its
                             // parameter
    public String listStudent(Model model// This model is actually just a placeholder for the data that is passed to
                                         // this method and that data is being used in the body to show the conta
    ) {
        model.addAttribute("students", studentService.getAllStudents());//syntax to fetch and pass data to show in the page
        return "students";// This will be the html file name that will be used to show the webpage
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students") // Annotation to declare this method as a post request for the url path in its
                              // parameter
    public String saveStudent(@ModelAttribute("student") Student student)// The ModelAttribute will fill data in the
                                                                         // student model attribute from a form that was
                                                                         // submitted in the previous page
    {
        studentService.saveStudent(student);
        return "redirect:/students";// This is the syntax to redirect the page to the given url as a return
                                    // statement. We cannot use just the student page without redirect because it
                                    // actually creates a get request for the students page and the get request
                                    // return statement follows the syntax.
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, // This annotation us used to get the variable, which is in
                                                         // brackets in the getmapping annotation, and pass it in the
                                                         // parameter of the method. Can be used with multiple
                                                         // parameters of the method
            Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
        // get student by id from db
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // save upddated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
