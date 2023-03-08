package com.ltx.mybatis.mapper;

import com.ltx.mybatis.pojo.Car;
import com.ltx.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class CarMapperTest {


    @Test
    public void testSelectById2(){
        SqlSessionFactory sqlSessionFactory = null;

        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();

        CarMapper mapper1 = sqlSession1.getMapper(CarMapper.class);
        CarMapper mapper2 = sqlSession2.getMapper(CarMapper.class);

        Car car1 = mapper1.selectById2(2L);
        System.out.println(car1);

        /**
         * 如果在这里关闭了SQLSession1，那么sqlSession1中的一级缓存就会被写入到二级缓存，
         * 那么在sqlSession2中查询这一条数据，就会在二级缓存中找到数据，就不会在去数据库中查了
         */
        sqlSession1.close();

        Car car2 = mapper2.selectById2(2L);
        System.out.println(car2);

        /**
         * 如果此时关闭了SQLSession1，那此时查询到得car1才会被写入到二级缓存，
         * 所以mapper2查询的时候没有在二级缓存中找到数据，才会再查询一次
         */
        //sqlSession1.close();

        sqlSession2.close();

    }

    @Test
    public void testSelectById(){




        /**
        mybatis中提供了两级缓存：一级缓存：SqlSession 二级缓存：SqlSessionFactory
            这里走了mybatis的一级缓存,一级缓存默认情况下是开启的,
            因为这里执行的是同一条SQL语句，所以走了一级缓存

            其中，如果在两次查询语句中间干了这些事，就会清除缓存：
                1、手动清除缓存：执行sqlSession.clearCache()方法
                2、执行insert，delete，update其中的任意一种语句(对任意表执行都会清除缓存，并不只是当前操作的数据库表)
         */
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        Car car1 = mapper.selectById(1L);
        System.out.println(car1);

        Car car2 = mapper.selectById(1L);
        System.out.println(car2);

        sqlSession.close();

        /**
         * 用两个不同的SQLSession就不可以走一级缓存了
         *      这就说明一级缓存的范围就是一次SQLSession会话
         */
        /*SqlSession sqlSession1 = SqlSessionUtil.openSession();
        CarMapper mapper1 = sqlSession1.getMapper(CarMapper.class);
        Car car1 = mapper1.selectById(1L);
        System.out.println(car1);
        SqlSessionUtil.close(sqlSession1);

        SqlSession sqlSession2 = SqlSessionUtil.openSession();
        CarMapper mapper2 = sqlSession2.getMapper(CarMapper.class);
        Car car2 = mapper2.selectById(1L);
        System.out.println(car2);
        sqlSession2.close();*/


    }
}
