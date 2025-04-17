package jsp.spring.springboot_project.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.spring.springboot_project.dao.CourseDao;
import jsp.spring.springboot_project.dao.EnrollmentDao;
import jsp.spring.springboot_project.dao.StudentDao;
import jsp.spring.springboot_project.exception.CourseNotFoundException;
import jsp.spring.springboot_project.exception.ResourceNotFoundException;
import jsp.spring.springboot_project.exception.StudentNotFoundException;
import jsp.spring.springboot_project.model.Course;
import jsp.spring.springboot_project.model.Enrollment;
import jsp.spring.springboot_project.model.Student;
import jsp.spring.springboot_project.response.ResponseStructure;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentDao enrollmentDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CourseDao courseDao;
    public ResponseEntity<ResponseStructure<Enrollment>> savEnrollment(Enrollment enrollment, int sid, int cid) {
        Optional<Student> st = studentDao.getStudentById(sid);
        Optional<Course> cs = courseDao.getCourseById(cid);
        if (st.isPresent()) {
            enrollment.setStudent(st.get());
        } else {
            throw new StudentNotFoundException();
        }
        if (cs.isPresent()) {
            enrollment.setCourse(cs.get());
        } else {
            throw new CourseNotFoundException();
        }
        enrollmentDao.addEnrollment(enrollment);
        ResponseStructure<Enrollment> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setMessage("Succes");
        response.setData(enrollment);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<List<Enrollment>>> getAll() {
        List<Enrollment> enrollments = enrollmentDao.getAllEnrollments();
        ResponseStructure<List<Enrollment>> response = new ResponseStructure<>();
        if (!enrollments.isEmpty()) {
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Succes");
            response.setData(enrollments);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public ResponseEntity<ResponseStructure<Enrollment>> getEnrollmentById(int id) {
        Optional<Enrollment> enrollment = enrollmentDao.findById(id);
        if (enrollment.isPresent()) {
            ResponseStructure<Enrollment> response = new ResponseStructure<>();
            response.setStatusCode(HttpStatus.FOUND.value());
            response.setMessage("Succes");
            response.setData(enrollment.get());
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public ResponseEntity<ResponseStructure<Enrollment>> updateDate(int id, LocalDate date) {
        Optional<Enrollment> enrollment = enrollmentDao.findById(id);
        if (enrollment.isPresent()) {
            ResponseStructure<Enrollment> response = new ResponseStructure<>();
            enrollment.get().setEnrolledDate(date);
            enrollmentDao.addEnrollment(enrollment.get());
            response.setStatusCode(HttpStatus.FOUND.value());
            response.setMessage("Succes");
            response.setData(enrollment.get());
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public ResponseEntity<ResponseStructure<String>> deleteEnrollment(int id) {
        Optional<Enrollment> enrollment = enrollmentDao.findById(id);
        if (enrollment.isPresent()) {
            enrollmentDao.deleteEnrollment(id);
            ResponseStructure<String> response = new ResponseStructure<>();
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Succes");
            response.setData("Enrollment deleted");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public ResponseEntity<ResponseStructure<Enrollment>> getStudentByEnrollmentId(int id) {
        Optional<Enrollment> student = enrollmentDao.getStudentByEnrollmentId(id);
        if (student.isPresent()) {
            ResponseStructure<Enrollment> response = new ResponseStructure<>();
            response.setStatusCode(HttpStatus.FOUND.value());
            response.setMessage("Succes");
            response.setData(student.get());
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public ResponseEntity<ResponseStructure<List<Enrollment>>> getCourseByEnrollmentId(int id) {
        List<Enrollment> course = enrollmentDao.getCourseByEnrollmentId(id);
        if (!course.isEmpty()) {
            ResponseStructure<List<Enrollment>> response = new ResponseStructure<>();
            response.setStatusCode(HttpStatus.FOUND.value());
            response.setMessage("Succes");
            response.setData(course);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        } else {
            throw new ResourceNotFoundException();
        }
    }

}
