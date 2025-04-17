package jsp.spring.springboot_project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.spring.springboot_project.model.Enrollment;
import jsp.spring.springboot_project.repository.EnrollmentRepository;

@Repository
public class EnrollmentDao {
  @Autowired
  private EnrollmentRepository enrollmentRepository;
  public Enrollment addEnrollment(Enrollment enrollment) {
    return enrollmentRepository.save(enrollment);
  }
  public Optional<Enrollment> getStudentByEnrollmentId(int enrollmentId) {
    return enrollmentRepository.findStudentById(enrollmentId);
  }
  public List<Enrollment> getCourseByEnrollmentId(int enrollmentId) {
    return enrollmentRepository.findCourseById(enrollmentId);
  }
  public List<Enrollment> getAllEnrollments() {
    return enrollmentRepository.findAll();
  }
  public Optional<Enrollment> findById(int id){
    return enrollmentRepository.findById(id);
  }
  public void deleteEnrollment(int id) {
    enrollmentRepository.deleteById(id);
  }
  public List<Enrollment> getCourseById(int id){
    return enrollmentRepository.findCourseById(id);
  }
  public Optional<Enrollment> getStudentById(int id){
    return enrollmentRepository.findStudentById(id);
  }
}
