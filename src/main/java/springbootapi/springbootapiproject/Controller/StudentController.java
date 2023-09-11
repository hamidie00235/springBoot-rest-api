package springbootapi.springbootapiproject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootapi.springbootapiproject.Bean.Student;
@RestController
public class StudentController {
    /// Http://localhost:8080/student

    @GetMapping("/student")
    public Student getStudent(){
        Student student =new Student(1L,
                "hamidie",
                "ahmet");

        return student;
    }
}
