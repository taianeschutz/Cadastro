package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class EmployeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> itemNotFoundHandler(IndexOutOfBoundsException ex) {
    //return ex.getMessage();
    Map<String, String> message = new HashMap<>();
    message.put("erro", "Item não encontrado");
    return message;
    }
}