package com.ltx.springmvc.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Student {

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Student(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Student() {
    }
}
