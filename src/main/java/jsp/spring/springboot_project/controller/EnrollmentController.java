package jsp.spring.springboot_project.controller;

import java.time.LocalDate;
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

import jsp.spring.springboot_project.model.Enrollment;
import jsp.spring.springboot_project.response.ResponseStructure;
import jsp.spring.springboot_project.service.EnrollmentService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/enrollment")
@RestController
public class EnrollmentController {
  @Autowired
  private EnrollmentService  enrollmentService;
  @PostMapping("/{sid}/{cid}")
  public ResponseEntity<ResponseStructure<Enrollment>> addEnrollment(@RequestBody Enrollment enrollment,@PathVariable int sid , @PathVariable int cid) {
    return enrollmentService.savEnrollment(enrollment, sid, cid);
  }
  @GetMapping("/all")
  public ResponseEntity<ResponseStructure<List<Enrollment>>> getAllEnrollments() {
    return enrollmentService.getAll();
  }
  @PutMapping
  public ResponseEntity<ResponseStructure<Enrollment>> updateDate(@RequestParam LocalDate date , @RequestParam int id) {
    return enrollmentService.updateDate(id, date);
  }
  @DeleteMapping
  public ResponseEntity<ResponseStructure<String>> deleteEnrollment(@RequestParam int id) {
    return enrollmentService.deleteEnrollment(id);
  }
  @GetMapping("/student/{id}")
  public ResponseEntity<ResponseStructure<Enrollment>> getStudent(@PathVariable int id) {
    return enrollmentService.getStudentByEnrollmentId(id);
  }
  @GetMapping("/course/{id}")
  public ResponseEntity<ResponseStructure<List<Enrollment>>> getCourse(@PathVariable int id) {
    return enrollmentService.getCourseByEnrollmentId(id);
  }
}
