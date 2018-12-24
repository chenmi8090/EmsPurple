package com.baizhi.dao;

import com.baizhi.entity.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LogsDAO {

    //查询所有日志
    public List<Log> queryAllLogs(@Param("pageStart")Integer pageStart,@Param("pageEnd") Integer pageEnd);

    //查询日志条数
    public Integer queryCounts();

    //添加日志
    public void insertLog(Log log);

}
