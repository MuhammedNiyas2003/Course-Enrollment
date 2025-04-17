package jsp.spring.springboot_project.model;

import java.time.LocalDate;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Enrollment {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private LocalDate enrolledDate;
  @JoinColumn
  @ManyToOne(cascade=CascadeType.ALL)
  private Student student;
  @JoinColumn
  @ManyToOne(cascade=CascadeType.ALL)
  private Course course;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public LocalDate getEnrolledDate() {
    return enrolledDate;
  }
  public void setEnrolledDate(LocalDate enrolledDate) {
    this.enrolledDate = enrolledDate;
  }
  public Student getStudent() {
    return student;
  }
  public void setStudent(Student student) {
    this.student = student;
  }
  public Course getCourse() {
    return course;
  }
  public void setCourse(Course course) {
    this.course = course;
  }
  @Override
  public String toString() {
    return "Enrollment [id=" + id + ", enrolledDate=" + enrolledDate + ", student=" + student + ", course=" + course
        + "]";
  }
  
}
