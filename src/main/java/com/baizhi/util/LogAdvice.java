package com.baizhi.util;


import com.baizhi.controller.EmployeeController;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Employee;
import com.baizhi.entity.Log;
import com.baizhi.service.LogsService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * 自定义日志相关类(AspectJ)
 * 2018年12月15日 17点38分
 * 方法： 利用环绕通知方法进行日志类的创建
 * 注意： 用户参数为：Redis中获取;
 * 时间参数为：new Date();
 * 级别参数为：配置文件配置;
 * 操作内容：根据要求书写内容;
 * 操作结果：try{}catch(){}的结果Result对象;
 */

//标识当前类为额外功能类
@Aspect
//标识该额外功能类交由Spring工厂管理创建
@Component
public class LogAdvice {

    //对应 该类生成日志文件对象
    private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);

    //配置在com.baizhi包下的所有方法都经过日志
    @Pointcut(value = "execution(* com.baizhi.service.AdminServiceImpl.*Admin(..))||execution(* com.baizhi.service.EmployeeServiceImpl.*Employee(..))")
    public void pointCut() {
    }

    @Autowired
    private LogsService logsService;

    //连接Redis数据库
    @Autowired
    private Jedis jedis;

    //声明环绕通知
    @Around(value = "pointCut()")
    public Object methodAround(ProceedingJoinPoint pjp) {
        MethodSignature methodSignature = null;
        String success = null;
        Object proceed = null;
        Log log = new Log();
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        try {
            //放行
            proceed = pjp.proceed();
            success = "true";
        } catch (Throwable t) {
            t.printStackTrace();
            //操作结果
            success = "false";
        }
        //Admin admin = (Admin) request.getSession().getAttribute("admin");
        methodSignature = (MethodSignature) pjp.getSignature();
        //方法名
        String name = methodSignature.getName();
        //获取参数对象属性
        Object[] args = pjp.getArgs();
        //获取Jedis中操作该页面的用户信息
        log.setId(UUID.randomUUID().toString());
        log.setDatetime(new Date());
        log.setSuccess(success);
        if (name.contains("addAdmin")) {
            log.setMessage("添加了一个管理员，管理员的信息为：" + args[0]);
        } else if (name.contains("modify")) {
            log.setMessage("修改了一个用户，修改的信息为：" + args[0]);
        } else if (name.contains("remove")) {
            log.setMessage("删除了一个id为 " + args[0] + " 的用户信息");
        } else if (name.contains("add")) {
            log.setMessage("添加了一个用户，用户的信息为：" + args[0]);
        }
       // if(admin.getName() != null){
           // log.setName(admin.getName());
        //}
        logsService.addLog(log);
        return proceed;
    }
}
