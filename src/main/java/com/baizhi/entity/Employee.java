package com.baizhi.entity;

// 员工 实体类

public class Employee {
    private String id;
    private String name;
    private Double salary;
    private Integer age;
    private String status;

    public Employee() {
    }

    public Employee(String id, String name, Double salary, Integer age, String status) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.status = status;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", status='" + status;

    }
}
