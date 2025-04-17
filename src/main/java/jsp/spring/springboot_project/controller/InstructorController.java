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

import jsp.spring.springboot_project.model.Instructor;
import jsp.spring.springboot_project.model.Student;
import jsp.spring.springboot_project.response.ResponseStructure;
import jsp.spring.springboot_project.service.InstructorService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/instructor")
@RestController
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Instructor>> saveInstructor(@RequestBody Instructor instructor) {
        return instructorService.addInstructor(instructor);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseStructure<List<Instructor>>> getAllInstructors() {
        return instructorService.getAllInstructor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Instructor>> getInstructorById(@PathVariable int id) {
        return instructorService.getInstructorById(id);
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<Instructor>> updateInstructor(@RequestBody Instructor instructor) {
        return instructorService.updateInstructor(instructor);
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<ResponseStructure<List<Student>>> getStudentByInstructorId(@PathVariable int id) {
        return instructorService.getStudentsById(id);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<Instructor>> getInstructorByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        return instructorService.getByEmailAndPassword(email, password);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteInstructor(@PathVariable int id){
        return instructorService.deleteInstructor(id);
    }
}
