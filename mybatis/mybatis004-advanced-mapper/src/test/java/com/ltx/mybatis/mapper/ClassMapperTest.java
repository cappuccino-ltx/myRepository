package com.ltx.mybatis.mapper;

import com.ltx.mybatis.pojo.Class;
import com.ltx.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ClassMapperTest {

    @Test
    public void testSelectByIdStep1(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        Class aClass = mapper.selectByIdStep1(1001);
        System.out.println(aClass);
        sqlSession.close();
    }

    @Test
    public void testSelectByCollection(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        Class clazz = mapper.selectByCollection(1001);
        System.out.println(clazz);
        sqlSession.close();
    }
}
