package jsp.spring.springboot_project.model;

import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Course {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String title;
  private double fee;
  private String duration;
  @JsonIgnore
  @OneToMany(mappedBy="course",cascade=CascadeType.ALL)
  private List<Enrollment> enrollments;
  @JoinColumn
  @ManyToOne(cascade=CascadeType.ALL)
  private Instructor instructor;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public double getFee() {
    return fee;
  }
  public void setFee(double fee) {
    this.fee = fee;
  }
  public String getDuration() {
    return duration;
  }
  public void setDuration(String duration) {
    this.duration = duration;
  }
  public List<Enrollment> getEnrollments() {
    return enrollments;
  }
  public void setEnrollments(List<Enrollment> enrollments) {
    this.enrollments = enrollments;
  }
  public Instructor getInstructor() {
    return instructor;
  }
  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }
  @Override
  public String toString() {
    return "Course [id=" + id + ", title=" + title + ", fee=" + fee + ", duration=" + duration + ", enrollments="
        + enrollments + ", instructor=" + instructor + "]";
  }
  
  
}
