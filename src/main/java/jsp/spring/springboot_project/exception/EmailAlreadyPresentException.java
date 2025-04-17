package jsp.spring.springboot_project.exception;

public class EmailAlreadyPresentException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Email is already present";
    }
  
}
