package com.coffee.tharpe.CoffeeShop.error;

import com.coffee.tharpe.CoffeeShop.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    //handles the coffee not found exception
    @ExceptionHandler(CoffeeNotFoundException.class)
    public ResponseEntity<ErrorMessage> coffeeNotFoundException(CoffeeNotFoundException exception,
                                                                WebRequest request){
        //creating message for not found
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
