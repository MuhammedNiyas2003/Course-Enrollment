package jsp.spring.springboot_project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import jakarta.persistence.QueryHint;
import jsp.spring.springboot_project.model.Enrollment;

public interface  EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
  @Query("select e from Enrollment e where e.student.id = ?1")
  @QueryHints(@QueryHint(name = "org.hibernate.cacheable", value = "true"))
  Optional<Enrollment> findStudentById(int id);  
  @Query("select e from Enrollment e where e.course.id = ?1")
  @QueryHints(@QueryHint(name = "org.hibernate.cacheable", value = "true"))
  List<Enrollment> findCourseById(int id);
}
