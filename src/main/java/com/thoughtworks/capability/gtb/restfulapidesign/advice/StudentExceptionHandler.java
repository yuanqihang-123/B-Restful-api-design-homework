package com.thoughtworks.capability.gtb.restfulapidesign.advice;

import com.thoughtworks.capability.gtb.restfulapidesign.DTO.ResponseDTO;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(StudentException.class)
    public ResponseEntity<ResponseDTO> handle(StudentException e) {
        ResponseDTO responseDTO = new ResponseDTO(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }

}
