package jsp.spring.springboot_project.model;


import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Student {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String name;
  @Column(unique=true)
  private String email;
  private String password;
  private LocalDate dob;
  @JsonIgnore
  @OneToMany(mappedBy="student",cascade=CascadeType.ALL)
  private List<Enrollment> enrollments;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public LocalDate getDob() {
    return dob;
  }
  public void setDob(LocalDate dob) {
    this.dob = dob;
  }
  public List<Enrollment> getEnrollments() {
    return enrollments;
  }
  public void setEnrollments(List<Enrollment> enrollments) {
    this.enrollments = enrollments;
  }
  
}