package net.javaguides.sms.entitity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // This is the annotation to declare the class can be mapped to the table in
        // JPA.
@Table(name = "Students") // Declares this class entitiy to be of the Students tbale in database. Creates
                          // the table if not present.
public class Student {

    @Id // Mandatory in JPA to define this variable in every entity which is the primary
        // key of the table.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This annotatin provides a way to generate primary key. In
                                                        // case of the IDENTITY generation type, it generates an
                                                        // incrementing id on every addition of data in the table.
    private long id;

    @Column(name = "first_name", nullable = false) // Column definition through this annotation
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
