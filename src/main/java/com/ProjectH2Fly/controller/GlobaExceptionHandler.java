package com.ProjectH2Fly.controller;

import com.ProjectH2Fly.exceptions.Custom400Exception;
import com.ProjectH2Fly.exceptions.Custom500Exception;
import com.ProjectH2Fly.model.Log;
import com.ProjectH2Fly.serviceInterface.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobaExceptionHandler {
    @Autowired
    ILogService<Log> log;
    @ExceptionHandler(Custom400Exception.class)
    public ResponseEntity handleCustomException400(final Custom400Exception ex){
    log.addLog(new Log(this.getClass().toString()));
    return new ResponseEntity<>("Bledne dane", HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(Custom500Exception.class)
    public ResponseEntity handleCustomException500(final Custom500Exception ex){
        log.addLog(new Log(this.getClass().toString()));
        return new ResponseEntity<>("Wewnetrzne problemy z serwerem", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleJsonParseError(HttpMessageNotReadableException ex) {
        // Rzuć własny wyjątek
        log.addLog(new Log(this.getClass().toString()));
        return new ResponseEntity<>("Bledne dane", HttpStatus.I_AM_A_TEAPOT);
    }

    // Obsługa własnego wyjątku
//    @ExceptionHandler(Custom400Exception.class)
//    public ResponseEntity<String> handleCustomJsonParseException(Custom400Exception ex) {
//        return new ResponseEntity<>("Bledne dane", HttpStatus.I_AM_A_TEAPOT);
//    }

}
