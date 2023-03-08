package com.ltx.mybatis.test;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.ltx.mybatis.pojo.Car;
import com.ltx.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {

    @Test
    public void testSelectAll(){
        SqlSession session = SqlSessionUtil.openSession();

        //执行SQL语句
        List<Car> result = session.selectList("selectAll");
        /*for (Car car :result) {
            System.out.println(car);
        }*/
        //lambda表达式
        result.forEach(car -> System.out.println(car));

        session.commit();
        session.close();
    }

    @Test
    public void testSelectCarById(){
        SqlSession session = SqlSessionUtil.openSession();

        //执行SQL语句
        Object car = session.selectOne("selectCarById", "4");
        System.out.println(car);

        session.commit();
        session.close();
    }

    @Test
    public void testInsertCarByPojo(){
        SqlSession session  = SqlSessionUtil.openSession();
        Car car = new Car((Long) null, "1005", "宝马E6", 50L, "2017-01-01", "燃油车");
        session.insert("insertCar",car);
        session.commit();
        session.close();
    }
    @Test
    public void testDeleteCarById(){
        SqlSession session = SqlSessionUtil.openSession();

        //执行SQL语句
        session.delete("deleteCarById",7);

        session.commit();
        session.close();
    }
    @Test
    public void testUpdateCarById(){
        SqlSession session = SqlSessionUtil.openSession();

        //执行SQL语句
        Car car = new Car(4L, "1006", "宝骏", 5L, "2010-10-01", "燃油车");
        session.update("updateCarById",car);

        session.commit();
        session.close();
    }
}
