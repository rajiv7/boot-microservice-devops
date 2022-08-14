package com.github.rajiv7.ms.api.department.config;

import com.github.rajiv7.ms.api.department.exception.ApiJpaExceptionVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiJpaExceptionVO handleRestException(ConstraintViolationException ex, WebRequest request){
        return new ApiJpaExceptionVO("ConstraintViolationException", buildEx(ex.getConstraintViolations()));
    }

    private String buildEx(Set<ConstraintViolation<?>> exCol) {
       return exCol.stream()
               .map(item -> "'" + item.getPropertyPath().toString() + "' " + item.getMessage())
               .collect(Collectors.toList()).toString();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiJpaExceptionVO handleRestException(MethodArgumentNotValidException ex, WebRequest request){
        return new ApiJpaExceptionVO("MethodArgumentNotValidException", ex.getMessage());
    }
    
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ResponseBody
	public ApiJpaExceptionVO handleRestException(EntityNotFoundException ex, WebRequest request){
        return new ApiJpaExceptionVO("EntityNotFoundException", ex.getMessage());
    }
}