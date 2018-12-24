package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//日志类

public class Log {

    private String id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date datetime;
    private String message;
    private String success;

    public Log() {
    }

    public Log(String id, String name, Date datetime, String message, String success) {
        this.id = id;
        this.name = name;
        this.datetime = datetime;
        this.message = message;
        this.success = success;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", datetime=" + datetime +
                ", message='" + message + '\'' +
                ", success='" + success + '\'' +
                '}';
    }
}
