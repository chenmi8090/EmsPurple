package com.baizhi.service;

import com.baizhi.dao.LogsDAO;
import com.baizhi.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LogsServiceImpl implements LogsService {

    @Autowired
    private LogsDAO logsDAO;

    //分页每页条数
    @Value(value="${rows}")
    private String rows;

    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public List<Log> findAllLogs(Integer page) {
        Integer row = Integer.valueOf(rows);
        if(page==null || page==0){
            page=1;
        }
        Integer pageStart = (page-1)*row;
        Integer pageEnd = page*row;
        //return logsDAO.queryAllLogs(pageStart,pageEnd);
        return logsDAO.queryAllLogs(pageStart,row);
    }

    @Override
    public Integer findCounts() {
        Integer counts = logsDAO.queryCounts();
        //计算出最大页数
        Integer row = Integer.valueOf(rows);
        Integer maxPage;
        if(counts%row==0){
            maxPage=counts/row;
        }else{
            maxPage=counts/row+1;
        }
        return maxPage;
    }

    @Override
    public void addLog(Log log) {
        logsDAO.insertLog(log);
    }
}
