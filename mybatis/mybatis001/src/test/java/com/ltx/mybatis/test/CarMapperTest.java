package com.ltx.mybatis.test;

import com.ltx.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class CarMapperTest {
    @Test
    public void testInsertCar(){
        SqlSession sqlSession = null;
        try {
            //获取SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

            //获取SqlSessionFactory对象
            //build方法需要一个InputStream,输入流，将主配置文件加载进去
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));

            //获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession();
            //SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();

            //执行SQL语句，完成相应的业务
            int count = sqlSession.insert("insertCar");
            System.out.println("插入记录条数：" + count);

            sqlSession.commit();
        } catch (IOException e) {
            if (sqlSession != null) {
                sqlSession.close();
            }
            throw new RuntimeException(e);
        }finally{

        }
    }
    @Test
    public void testInsertCarByUtil(){
        SqlSession session = SqlSessionUtil.openSession();
        int count = session.insert("insertCar");
        System.out.println(count);
        session.commit();
        session.close();
    }
}
