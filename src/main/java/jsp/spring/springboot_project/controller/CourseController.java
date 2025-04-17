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
import jsp.spring.springboot_project.response.ResponseStructure;
import jsp.spring.springboot_project.service.CourseService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/course")
@RestController
public class CourseController {
  @Autowired
  private CourseService courseService;
  @PostMapping
  public ResponseEntity<ResponseStructure<Course>> saveCourse(@RequestBody Course course ,@RequestParam int id) {
    return courseService.saveCourse(course, id);
  }
  @GetMapping
  public ResponseEntity<ResponseStructure<List<Course>>> getAllCourses() {
    return courseService.getAllCourses();
  }
  @GetMapping("/{id}")
  public ResponseEntity<ResponseStructure<Course>>getById(@RequestParam int id){
      return courseService.getCourseById(id);
  }
  @PutMapping
  public ResponseEntity<ResponseStructure<Course>> updateCourse(@RequestBody Course course) {
    return courseService.updateCourse(course);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseStructure<String>> deleteCourse(@PathVariable int id) {
    return courseService.deleteCourse(id);
  }
  @GetMapping("/list")
  public ResponseEntity<ResponseStructure<List<Course>>> getCourseByStudentId(@RequestParam int id) {
    return courseService.getCourseByInstructorId(id);
  }
}
