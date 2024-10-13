package com.ProjectH2Fly.service;

import com.ProjectH2Fly.model.Log;
import com.ProjectH2Fly.repository.ILogRepository;
import com.ProjectH2Fly.serviceInterface.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService implements ILogService<Log> {
    @Autowired
    ILogRepository repository;

    public List<Log> getLog() {
        return repository.findAll();
    }
    public void addLog(Log log){
        repository.save(log);
    }

}
