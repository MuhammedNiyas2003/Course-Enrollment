package jsp.spring.springboot_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jsp.spring.springboot_project.model.Course;
import jsp.spring.springboot_project.model.Student;
import jsp.spring.springboot_project.response.ResponseStructure;
import jsp.spring.springboot_project.service.StudentService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student) {
        return studentService.savStudent(student);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseStructure<List<Student>>> getAllStudents() {
        return studentService.getAllStudent();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Student>> getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteStudentById(@PathVariable int id) {
        return studentService.deleteStudentById(id);
    }
    @GetMapping("/courses/{id}")
    public ResponseEntity<ResponseStructure<List<Course>>> getCourses(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }
    @GetMapping
    public ResponseEntity<ResponseStructure<Student>> getStudentByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        return studentService.getStudentByEmailAndPassword(email, password);
    }
    
}
