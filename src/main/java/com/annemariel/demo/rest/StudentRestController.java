package com.annemariel.demo.rest;

import com.annemariel.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to lad the student data... only once!

    @PostConstruct
    public void loadData() {

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Joe", "Doe"));
        theStudents.add(new Student("Cae", "Dee"));
        theStudents.add(new Student("Nick", "Dy"));
    }

    // define endpoint for "/students" - return a list of  students

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // define endpoint or "/students/(studentId)" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        return theStudents.get(studentId);
    }

}
