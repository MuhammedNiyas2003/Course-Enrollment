package jsp.spring.springboot_project.exception;

public class ResourceNotFoundException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Resource not found";
    }
  
}
