package jsp.spring.springboot_project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.QueryHint;
import jsp.spring.springboot_project.model.Instructor;
import jsp.spring.springboot_project.model.Student;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    @Query("select distinct e.student from Enrollment e where e.course.instructor.id = ?1")
    @QueryHints(@QueryHint(name = "org.hibernate.cacheable", value = "true"))
    List<Student> findStudentsByInstructor(int id);
    @Query("select i from Instructor i where i.email = ?1 and i.password = ?2")
    @QueryHints(@QueryHint(name = "org.hibernate.cacheable", value = "true"))
    Optional<Instructor> findInstructorByEmailAndPassword(@Param("email")String email,@Param("password")String password);
    Optional<Instructor> findByEmail(String email);
}
