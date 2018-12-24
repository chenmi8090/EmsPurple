package com.baizhi.entity;

//管理员实体类

public class Admin {
    private String id;
    private String name;
    private String username;
    private String password;
    private String salt;
    private String sex;
    private String status;

    public Admin() {
    }

    public Admin(String username){
        this.username = username;
    }

    public Admin(String id, String name, String username, String password, String salt, String sex, String status) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.sex = sex;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", sex='" + sex + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
