package schoolmanager.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Student Does Not Exist")
public class StudentDoesNotExistException extends RuntimeException{

    public StudentDoesNotExistException(Long id){
        super("Student " + id + " Does Not Exist.");
    }
}
