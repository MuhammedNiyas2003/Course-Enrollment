package jsp.spring.springboot_project.exception;

public class StudentNotFoundException extends RuntimeException{

  @Override
  public String getMessage() {
      return "Invalid Student Id";
  }

}
