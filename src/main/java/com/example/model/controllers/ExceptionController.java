package com.example.model.controllers;


import com.example.model.exceptions.RecordNotFoundException;
import com.example.model.exceptions.TelevisionNameTooLongException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<String> exception(RecordNotFoundException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = TelevisionNameTooLongException.class)
    public ResponseEntity<String> exception(TelevisionNameTooLongException exception) {

        return new ResponseEntity<>("Dit tv naam is te lang", HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity<String> exception(IndexOutOfBoundsException exception) {
        return new ResponseEntity<>("Dit bestaat niet in de database", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<String> exception(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>("Niet alle waardes zijn ingevuld,vul deze graag in om door te gaan", HttpStatus.BAD_REQUEST);
    }

}
