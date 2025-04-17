package jsp.spring.springboot_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.spring.springboot_project.dao.StudentDao;
import jsp.spring.springboot_project.exception.EmailAlreadyPresentException;
import jsp.spring.springboot_project.exception.ResourceNotFoundException;
import jsp.spring.springboot_project.model.Course;
import jsp.spring.springboot_project.model.Student;
import jsp.spring.springboot_project.response.ResponseStructure;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public ResponseEntity<ResponseStructure<Student>> savStudent(Student student) {
        Optional<Student> st = studentDao.getStudentByEmail(student.getEmail());
        if (st.isPresent()) {
            throw new EmailAlreadyPresentException();
        } else {
            ResponseStructure<Student> rs = new ResponseStructure<>();
            rs.setStatusCode(HttpStatus.CREATED.value());
            rs.setMessage("Student saved");
            rs.setData(studentDao.saveStudent(student));
            return new ResponseEntity<>(rs, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<ResponseStructure<List<Student>>> getAllStudent() {
        ResponseStructure<List<Student>> rs = new ResponseStructure<>();
        List<Student> students = studentDao.getAllStudents();
        if (!students.isEmpty()) {
            rs.setStatusCode(HttpStatus.FOUND.value());
            rs.setMessage("Students found");
            rs.setData(students);
            return new ResponseEntity<>(rs, HttpStatus.FOUND);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public ResponseEntity<ResponseStructure<Student>> getStudentById(int id) {
        ResponseStructure<Student> rs = new ResponseStructure<>();
        Optional<Student> student = studentDao.getStudentById(id);
        if (student.isPresent()) {
            rs.setStatusCode(HttpStatus.FOUND.value());
            rs.setMessage("Student found");
            rs.setData(student.get());
            return new ResponseEntity<>(rs, HttpStatus.FOUND);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student) {
        ResponseStructure<Student> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Student updated");
        rs.setData(studentDao.updateStudent(student));
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> deleteStudentById(int id) {
        ResponseStructure<String> rs = new ResponseStructure<>();
        Optional<Student> student = studentDao.getStudentById(id);
        if (student.isPresent()) {
            studentDao.deleteStudent(id);
            rs.setStatusCode(HttpStatus.FOUND.value());
            rs.setMessage("Success");
            rs.setData("Student deleted");
            return new ResponseEntity<>(rs, HttpStatus.FOUND);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public ResponseEntity<ResponseStructure<List<Course>>> getCoursesByStudentId(int id) {
        ResponseStructure<List<Course>> rs = new ResponseStructure<>();
        List<Course> courses = studentDao.getCoursesByStudentId(id);
        if (!courses.isEmpty()) {
            rs.setStatusCode(HttpStatus.FOUND.value());
            rs.setMessage("Courses found");
            rs.setData(courses);
            return new ResponseEntity<>(rs, HttpStatus.FOUND);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public ResponseEntity<ResponseStructure<Student>> getStudentByEmailAndPassword(String email, String password) {
        Optional<Student> student = studentDao.getStudentByEmailAndPassword(email, password);
        if (student.isPresent()) {
            ResponseStructure<Student> rs = new ResponseStructure<>();
            rs.setStatusCode(HttpStatus.FOUND.value());
            rs.setMessage("Student found");
            rs.setData(student.get());
            return new ResponseEntity<>(rs, HttpStatus.FOUND);
        } else {
            throw new ResourceNotFoundException();
        }
    }

}
