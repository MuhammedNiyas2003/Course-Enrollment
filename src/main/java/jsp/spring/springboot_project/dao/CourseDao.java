package jsp.spring.springboot_project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.spring.springboot_project.model.Course;
import jsp.spring.springboot_project.repository.CourseRepository;

@Repository
public class CourseDao {
  @Autowired
  private CourseRepository courseRepository;
  public Course save(Course course) {
    return courseRepository.save(course);
  }
  public Optional<Course> getCourseById(int id) {
    return courseRepository.findById(id);
  }
  public List<Course> getAllCourses() {
    return courseRepository.findAll();
  }
  public void deleteCourse(Course course) {
    courseRepository.delete(course);
  }
  public List<Course> getCourseByInstructorId(int id){
    return courseRepository.findCoursesByInstructorId(id);
  }
}
