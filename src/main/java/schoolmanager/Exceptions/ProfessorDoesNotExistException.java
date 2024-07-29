package schoolmanager.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Course Does Not Exist")
public class ProfessorDoesNotExistException extends RuntimeException{

    public ProfessorDoesNotExistException(Long id){
        super("Professor " + id + " Does Not Exist.");
    }
}
