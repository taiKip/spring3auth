package com.example.api.error;

import com.example.api.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<ErrorMessage> userExistsException(UserExistsException exception,
                                                           WebRequest request){
ErrorMessage message = new ErrorMessage(HttpStatus.CONFLICT,exception.getMessage());

return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public  ResponseEntity<ErrorMessage> userNotFoundException(UserNotFoundException exception){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
