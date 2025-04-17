package jsp.spring.springboot_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import jakarta.persistence.QueryHint;
import jsp.spring.springboot_project.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query("select c from Course c where c.instructor.id = ?1")
    @QueryHints(@QueryHint(name = "org.hibernate.cacheable", value = "true"))
    List<Course> findCoursesByInstructorId(int id);
}
