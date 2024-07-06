package com.purohit.app.handleException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> res = new HashMap<String,String>();
        ex.getBindingResult().getFieldErrors().forEach(e->{
            res.put(e.getField(),e.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(res);
    }
}
