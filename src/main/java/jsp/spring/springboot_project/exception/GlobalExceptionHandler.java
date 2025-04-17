package jsp.spring.springboot_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jsp.spring.springboot_project.response.ResponseStructure;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleResourceNotFoundException() {
        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.NOT_FOUND.value());
        rs.setMessage("Resource not found");
        return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleStudentNotFoundException() {
        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.NOT_FOUND.value());
        rs.setMessage("Failure");
        return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleCourseNotFoundException() {
        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.NOT_FOUND.value());
        rs.setMessage("Failure");
        return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyPresentException.class)
    public ResponseEntity<ResponseStructure<String>> handleEmailAlreadyPresentException() {
        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
        rs.setMessage("Email already present");
        return new ResponseEntity<>(rs, HttpStatus.BAD_REQUEST);
    }
}
