package springbootapi.springbootapiproject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springbootapi.springbootapiproject.Bean.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    /// Http://localhost:8080/student

    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student(1L,
                "hamidie",
                "ahmet");

        return student;
    }
@GetMapping("/students")
    public List<Student> getStudents() {

    List<Student> students = new ArrayList<>();
    students.add(new Student(2L, "moussa", "oki"));
    students.add(new Student(3L, "you", "rozi"));
    students.add(new Student(4L, "dr", "abbali"));
    students.add(new Student(5L, "deco", "porta"));

    return students;
}
// 1 for path variable
    //  spring Boot rest api with path variable
    // {id} - URI template variable
    // http:// localhost:8080/student/1
//    @GetMapping("/students/{id}")
//    public Student pathVariable(@PathVariable Long id){
//        return new Student(id,"hamidie","koroma");
//    }
    //2 for path variable
    //  spring Boot rest api with path variable
    // {id} - URI template variable
    // http:// localhost:8080/student/1
//    @GetMapping("/students/{id}")
//    public Student pathVariable(@PathVariable ("id") Long studentId){
//        return new Student(studentId,"hamidie","koroma");
//    }
// 3 for multiple path variable
//  spring Boot rest api with path variable
// {id} - URI template variable
// http:// localhost:8080/student/1
@GetMapping("/students/{id}/{first-name}/{last-name}")
public Student pathVariable(@PathVariable ("id") Long studentId,
                            @PathVariable("first-name") String firstName,
                            @PathVariable("last-name") String lastName){
    return new Student(studentId,firstName,lastName);
}
}
