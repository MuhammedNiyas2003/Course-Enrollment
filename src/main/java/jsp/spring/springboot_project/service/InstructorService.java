package jsp.spring.springboot_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.spring.springboot_project.dao.InstructorDao;
import jsp.spring.springboot_project.exception.EmailAlreadyPresentException;
import jsp.spring.springboot_project.exception.ResourceNotFoundException;
import jsp.spring.springboot_project.model.Instructor;
import jsp.spring.springboot_project.model.Student;
import jsp.spring.springboot_project.response.ResponseStructure;

@Service
public class InstructorService {

    @Autowired
    private InstructorDao instructorDao;

    public ResponseEntity<ResponseStructure<Instructor>> addInstructor(Instructor instructor) {
        Optional<Instructor> existingInstructor = instructorDao.getInstructorByEmail(instructor.getEmail());
        if (existingInstructor.isPresent()) {
            throw new EmailAlreadyPresentException();
        } else {
            ResponseStructure<Instructor> rs = new ResponseStructure<>();
            rs.setStatusCode(HttpStatus.CREATED.value());
            rs.setMessage("Created");
            rs.setData(instructorDao.saveInstructor(instructor));
            return new ResponseEntity<>(rs, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<ResponseStructure<List<Instructor>>> getAllInstructor() {
        ResponseStructure<List<Instructor>> rs = new ResponseStructure<>();
        List<Instructor> instructors = instructorDao.getAllInstructors();
        if (!instructors.isEmpty()) {
            rs.setStatusCode(HttpStatus.FOUND.value());
            rs.setMessage("Succes");
            rs.setData(instructors);
            return new ResponseEntity<>(rs, HttpStatus.FOUND);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public ResponseEntity<ResponseStructure<Instructor>> getInstructorById(int id) {
        ResponseStructure<Instructor> rs = new ResponseStructure<>();
        Optional<Instructor> res = instructorDao.getInstructorById(id);
        if (res.isPresent()) {
            rs.setStatusCode(HttpStatus.FOUND.value());
            rs.setMessage("Succes");
            rs.setData(res.get());
            return new ResponseEntity<>(rs, HttpStatus.FOUND);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public ResponseEntity<ResponseStructure<Instructor>> updateInstructor(Instructor instructor) {
        ResponseStructure<Instructor> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.ACCEPTED.value());
        rs.setMessage("Updated");
        rs.setData(instructorDao.updateInstructor(instructor));
        return new ResponseEntity<>(rs, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<ResponseStructure<String>> deleteInstructor(int id) {
        ResponseStructure<String> rs = new ResponseStructure<>();
        Optional<Instructor> res = instructorDao.getInstructorById(id);
        if (res.isPresent()) {
            rs.setStatusCode(HttpStatus.OK.value());
            rs.setMessage("Success");
            instructorDao.deleteInstructor(id);
            rs.setData("Deleted");
            return new ResponseEntity<>(rs, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public ResponseEntity<ResponseStructure<List<Student>>> getStudentsById(int id) {
        ResponseStructure<List<Student>> rs = new ResponseStructure<>();
        List<Student> instructors = instructorDao.getStudentBytId(id);
        if (!instructors.isEmpty()) {
            rs.setStatusCode(HttpStatus.FOUND.value());
            rs.setMessage("Succes");
            rs.setData(instructors);
            return new ResponseEntity<>(rs, HttpStatus.FOUND);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public ResponseEntity<ResponseStructure<Instructor>> getByEmailAndPassword(String email, String password) {
        Optional<Instructor> res = instructorDao.getInstructorByEmailAndPassword(email, password);
        if (res.isPresent()) {
            ResponseStructure<Instructor> rs = new ResponseStructure<>();
            rs.setStatusCode(HttpStatus.FOUND.value());
            rs.setMessage("Succes");
            rs.setData(res.get());
            return new ResponseEntity<>(rs, HttpStatus.FOUND);
        } else {
            throw new ResourceNotFoundException();
        }
    }
}
