package com.baizhi.controller;

import com.baizhi.entity.Log;
import com.baizhi.service.LogsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/log")
public class LogsController {

    // 日志文件输出
    private static final Logger log = LoggerFactory.getLogger(LogsController.class);

    @Autowired
    private LogsService logsService;

    @RequestMapping("/findAllLogs")
    public ModelAndView findAllLogs(ModelAndView modelAndView,Integer page){
        if(page==null || page==0){
            page = 1;
        }
        List<Log> allLogs = logsService.findAllLogs(page);

        Integer maxPage = logsService.findCounts();
        modelAndView.addObject("logs",allLogs);
        modelAndView.addObject("page",page);
        modelAndView.addObject("maxPage",maxPage);

        modelAndView.setViewName("logslist");
        return modelAndView;
    }

}
