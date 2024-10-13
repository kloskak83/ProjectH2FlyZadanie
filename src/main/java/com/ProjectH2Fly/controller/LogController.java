package com.ProjectH2Fly.controller;

import com.ProjectH2Fly.model.Log;
import com.ProjectH2Fly.serviceInterface.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    @Autowired
    ILogService<Log> service;

    @GetMapping("/logs")
    public Iterable<Log> getLog() {
       return service.getLog();
    }
}
