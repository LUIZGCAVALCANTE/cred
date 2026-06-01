package com.izvoc.cred.Controllers;

import com.izvoc.cred.Dto.CustomError;
import com.izvoc.cred.Dto.ValidationError;
import com.izvoc.cred.Services.execptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError>
    resourceNotFound(ResourceNotFoundException e, HttpServletRequest request)
    {

        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err= new CustomError(Instant.now(), status.value(),
                e.getMessage(),request.getRequestURI());

        return ResponseEntity.status(status).body(err);


    }


    @ExceptionHandler({
            ObjectNotFoundException.class,
            EntityNotFoundException.class

    }

    )
    public ResponseEntity<CustomError>
    resourceNotFound(ObjectNotFoundException e, HttpServletRequest request)
    {

        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err= new CustomError(Instant.now(), status.value(),
                "Nao existe aqui o usuário buscado",request.getRequestURI());

        return ResponseEntity.status(status).body(err);


    }


    @ExceptionHandler({
            MethodArgumentNotValidException.class
    }
    )
    public ResponseEntity<CustomError>
    constraintViolation(MethodArgumentNotValidException e, HttpServletRequest request)
    {

        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        ValidationError err = new ValidationError(Instant.now(), status.value(),
                "Dados inválidos", request.getRequestURI());

            for (FieldError f: e.getBindingResult().getFieldErrors()){
                err.addError(f.getField(), f.getDefaultMessage());

            }

        return ResponseEntity.status(status).body(err);


    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<CustomError> dataIntegrity(
            DataIntegrityViolationException e,
            HttpServletRequest request) {

        CustomError err = new CustomError(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                "CPF já cadastrado, analise os dados inseridos",
                request.getRequestURI());

        return ResponseEntity.badRequest().body(err);
    }

}
