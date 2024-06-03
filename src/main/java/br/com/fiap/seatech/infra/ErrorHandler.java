package br.com.fiap.seatech.infra;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity error400(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(Error.class)
    public ResponseEntity error401(){
        return ResponseEntity.notFound().build();
    }


}