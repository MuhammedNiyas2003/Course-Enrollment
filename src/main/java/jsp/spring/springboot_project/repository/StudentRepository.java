package jsp.spring.springboot_project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.QueryHint;
import jsp.spring.springboot_project.model.Course;
import jsp.spring.springboot_project.model.Student;

public interface  StudentRepository extends JpaRepository<Student, Integer> {
  @Query("select distinct e.course  from Enrollment e where e.student.id =?1")
  @QueryHints(@QueryHint(name = "org.hibernate.cacheable", value = "true"))
  List<Course> findCoursesById(int id);
  @Query("select s from Student s where s.email =?1 and s.password = ?2" )  
  @QueryHints(@QueryHint(name = "org.hibernate.cacheable", value = "true"))
  Optional<Student> findStudentByEmailAndPassword(@Param("email")String email,@Param("password")String password);
  Optional<Student> findByEmail(String email);
}
