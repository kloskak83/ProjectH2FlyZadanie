package com.ProjectH2Fly.serviceInterface;

import com.ProjectH2Fly.model.Log;

import java.util.List;

public interface ILogService<T> {
    List<Log> getLog();
    void addLog(Log log);

}
