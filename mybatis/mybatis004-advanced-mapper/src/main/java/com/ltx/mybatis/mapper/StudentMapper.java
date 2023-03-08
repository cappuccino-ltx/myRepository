package com.ltx.mybatis.mapper;

import com.ltx.mybatis.pojo.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> selectByCidStep2(Integer cid);

    /**
     * 分布查询第一步(查询学生所在班级)
     * @param sid
     * @return
     */
    Student selectByIdStep1(Integer sid);

    /**
     * 使用association实现级联属性映射
     * @param sid
     * @return
     */
    Student selectByIdAssociation(Integer sid);
    /**
     * 级联属性映射，通过一条sql语句查询两张表的信息
     * @param sid
     * @return
     */
    Student selectById(Integer sid);

}
