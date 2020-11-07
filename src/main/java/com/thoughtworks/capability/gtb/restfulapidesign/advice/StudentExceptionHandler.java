package com.thoughtworks.capability.gtb.restfulapidesign.advice;

import com.thoughtworks.capability.gtb.restfulapidesign.DTO.ResponseDTO;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(StudentException.class)
    @ResponseBody
    public ResponseDTO handle(StudentException e){
        return new ResponseDTO(HttpStatus.NO_CONTENT.value(), e.getMessage());
    }

}
