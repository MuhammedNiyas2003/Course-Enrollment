package jsp.spring.springboot_project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.spring.springboot_project.model.Course;
import jsp.spring.springboot_project.model.Student;
import jsp.spring.springboot_project.repository.StudentRepository;

@Repository
public class StudentDao{
  @Autowired
  private StudentRepository studentRepository;
  public Student saveStudent(Student student) {
    return studentRepository.save(student);
  }
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }
  public Optional<Student> getStudentById(int id){
    return studentRepository.findById(id);
  }
  public Student updateStudent(Student student) {
    return studentRepository.save(student);
  }
  public void deleteStudent(int id) {
    studentRepository.deleteById(id);
  }
  public List<Course> getCoursesByStudentId(int id) {
    return studentRepository.findCoursesById(id);
  }
  public Optional<Student> getStudentByEmailAndPassword(String email, String password) {
    return studentRepository.findStudentByEmailAndPassword(email, password);
  }
  public Optional<Student> getStudentByEmail(String email) {
    return studentRepository.findByEmail(email);
  }

}