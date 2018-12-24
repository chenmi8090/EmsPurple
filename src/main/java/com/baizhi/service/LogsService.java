package com.baizhi.service;

import com.baizhi.entity.Log;

import java.util.List;

public interface LogsService {

    //查询日志方法
    public List<Log> findAllLogs(Integer page);

    //查询日志条数
    public Integer findCounts();

    //添加日志方法
    public void addLog(Log log);
}
