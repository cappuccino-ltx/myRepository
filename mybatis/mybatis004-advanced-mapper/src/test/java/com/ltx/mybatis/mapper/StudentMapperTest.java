package com.ltx.mybatis.mapper;

import com.ltx.mybatis.pojo.Student;
import com.ltx.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class StudentMapperTest {

    @Test
    public void TestSelectByIdStep1(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.selectByIdStep1(4);
        //正常输入查询到的信息，执行两条SQL语句
        //System.out.println(student);

        //输出学生的名字
        //开启延迟加载之后，没有用到第二条SQL语句查询到的结果，所以只执行了第一条SQL语句，、
        System.out.println(student.getSname());

        //当程序执行到这里，想看一下学生所在的班级，就用到了第二条SQL语句执行的结果表，才会执行第二条SQL语句
        System.out.println(student.getsClass().getCname());
        sqlSession.close();
    }
    @Test
    public void testSelectByIdAssociation(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.selectByIdAssociation(3);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(3);
        //System.out.println(student.getSid()+","+student.getSname()+","+student.getsClass().getCid()+","+student.getsClass().getCname());
        System.out.println(student);
        sqlSession.close();
    }
}
