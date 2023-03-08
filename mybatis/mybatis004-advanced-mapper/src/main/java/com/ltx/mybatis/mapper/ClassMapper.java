package com.ltx.mybatis.mapper;

import com.ltx.mybatis.pojo.Class;

public interface ClassMapper {

    /**
     * 分步查询一个班级中的所有学生
     * @param cid
     * @return
     */
    Class selectByIdStep1(Integer cid);

    /**
     * 查询一个班级中的学生
     * @param cid
     * @return
     */
    Class selectByCollection(Integer cid);

    /**
     * 通过id查询班级信息
     * @param cid
     * @return
     */
    Class selectById(Integer cid);
}
