package springbootapi.springbootapiproject.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springbootapi.springbootapiproject.Bean.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    /// Http://localhost:8080/student

    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student(1,
                "hamidie",
                "ahmet");

        return student;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        List<Student> students = new ArrayList<>();
        students.add(new Student(2, "moussa", "oki"));
        students.add(new Student(3, "you", "rozi"));
        students.add(new Student(4, "dr", "abbali"));
        students.add(new Student(5, "deco", "porta"));

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
    public Student pathVariable(@PathVariable("id") int studentId,
                                @PathVariable("first-name") String firstName,
                                @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

    // Spring Boot Rest Api with  Request Param
    // http:// localhost:8080/student/query?id=1
    // cas 1
//    @GetMapping("Students/query")
//    public Student studentRequestVariable(@RequestParam int id) {
//        return new Student(1, "you", "oki");
//    }
    // Spring Boot Rest Api with  Request Param
    // http:// localhost:8080/student/query?id=1&firstName&lastName
    // cas 2 for multiples Request Param
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam  String lastName) {
        return new Student(1,firstName, lastName);
    }
    // Spring Boot Rest Api that handles Http Post Request-create existing resource
    // @Postmapping and @RequestBody
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
    // Spring Boot Rest Api that handles HTTP PUT  Request -update existing resource
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student ,@PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
}