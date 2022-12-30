package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
//If there is no RequestMapping put GetMapping("/")
//If there is RequestMapping just leave it blank i.e. GetMapping()
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService =  studentService;
    }
    
    //Want to get students from database
    //which uses @GetMapping to retrieve objects from the server/database
    @GetMapping()
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    
    //want to post student into the database
    //which uses @PostMapping to post objects from the server/database
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }
    //want to delete students from the database
    //which uses @DeleteMapping to post objects from the server/database
    //@PathVariable extract the value of the template variables and assign their value to a method variable
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
    
    //want to edit students in the database
    //which uses @PutMapping to post objects from the server/database
    //@RequestPath annotation enables spring to extract input data that may be passed as a query, form data, or any arbitrary custom data.
    @PutMapping (path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }



}
