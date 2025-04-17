package jsp.spring.springboot_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.spring.springboot_project.dao.CourseDao;
import jsp.spring.springboot_project.dao.InstructorDao;
import jsp.spring.springboot_project.exception.ResourceNotFoundException;
import jsp.spring.springboot_project.model.Course;
import jsp.spring.springboot_project.model.Instructor;
import jsp.spring.springboot_project.response.ResponseStructure;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;
    @Autowired
    private InstructorDao instructorDao;

    public ResponseEntity<ResponseStructure<Course>> saveCourse(Course course, int instructorId) {
        Optional<Instructor> instructor = instructorDao.getInstructorById(instructorId);
        if (instructor.isPresent()) {
            ResponseStructure<Course> response = new ResponseStructure<>();
            course.setInstructor(instructor.get());
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setMessage("Success");
            response.setData(courseDao.save(course));
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public ResponseEntity<ResponseStructure<List<Course>>> getAllCourses() {
        List<Course> courses = courseDao.getAllCourses();
        if (!courses.isEmpty()) {
            ResponseStructure<List<Course>> response = new ResponseStructure<>();
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Success");
            response.setData(courses);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public ResponseEntity<ResponseStructure<Course>> getCourseById(int id) {
        Optional<Course> course = courseDao.getCourseById(id);
        if (course.isPresent()) {
            ResponseStructure<Course> response = new ResponseStructure<>();
            response.setStatusCode(HttpStatus.FOUND.value());
            response.setMessage("Success");
            response.setData(course.get());
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public ResponseEntity<ResponseStructure<Course>> updateCourse(Course course) {
        Course updatedCourse = courseDao.save(course);
        ResponseStructure<Course> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Success");
        response.setData(updatedCourse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> deleteCourse(int id) {
        Optional<Course> course = courseDao.getCourseById(id);
        if (course.isPresent()) {
            courseDao.deleteCourse(course.get());
            ResponseStructure<String> response = new ResponseStructure<>();
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public ResponseEntity<ResponseStructure<List<Course>>> getCourseByInstructorId(int id) {
        List<Course> courses = courseDao.getCourseByInstructorId(id);
        if (!courses.isEmpty()) {
            ResponseStructure<List<Course>> response = new ResponseStructure<>();
            response.setStatusCode(HttpStatus.FOUND.value());
            response.setMessage("Success");
            response.setData(courses);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        } else {
            throw new ResourceNotFoundException();
        }
    }

}
