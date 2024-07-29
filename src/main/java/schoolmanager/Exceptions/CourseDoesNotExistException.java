package schoolmanager.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Course Does Not Exist")
public class CourseDoesNotExistException extends RuntimeException{

    public CourseDoesNotExistException(Long id){
        super("Course " + id + " Does Not Exist.");
    }
}
