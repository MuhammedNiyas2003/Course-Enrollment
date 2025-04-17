package jsp.spring.springboot_project.exception;

public class CourseNotFoundException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Invalid Course Id";
    }
  
}
