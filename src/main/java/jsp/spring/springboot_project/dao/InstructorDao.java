package jsp.spring.springboot_project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.spring.springboot_project.model.Instructor;
import jsp.spring.springboot_project.model.Student;
import jsp.spring.springboot_project.repository.InstructorRepository;

@Repository
public class InstructorDao {

    @Autowired
    private InstructorRepository instructorRepository;

    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> getInstructorById(int id) {
        return instructorRepository.findById(id);
    }

    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public void deleteInstructor(int id) {
        instructorRepository.deleteById(id);
    }

    public List<Student> getStudentBytId(int id) {
        return instructorRepository.findStudentsByInstructor(id);
    }

    public Optional<Instructor> getInstructorByEmailAndPassword(String email, String password) {
        return instructorRepository.findInstructorByEmailAndPassword(email, password);
    }

    public Optional<Instructor> getInstructorByEmail(String email) {
        return instructorRepository.findByEmail(email);
    }
}
