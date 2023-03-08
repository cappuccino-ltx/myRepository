package com.ltx.mybatis.pojo;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {


    @Serial
    private static final long serialVersionUID = -1001304707157497981L;

    private Integer sid;
    private String sname;

    private Class sClass;


    public Student(Integer sid, String sname, Class sClass) {
        this.sid = sid;
        this.sname = sname;
        this.sClass = sClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sClass=" + sClass +
                '}';
    }

    public Class getsClass() {
        return sClass;
    }

    public void setsClass(Class sClass) {
        this.sClass = sClass;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Student(Integer sid, String sname) {
        this.sid = sid;
        this.sname = sname;
    }

    public Student() {
    }
}
