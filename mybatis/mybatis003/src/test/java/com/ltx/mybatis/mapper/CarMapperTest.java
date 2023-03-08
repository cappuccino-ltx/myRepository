package com.ltx.mybatis.mapper;

import com.ltx.mybatis.pojo.Car;
import com.ltx.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarMapperTest {

    @Test
    public void tesInsertWithForEach(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = new ArrayList<>();

        cars.add(new Car(null,"1007","宝骏E300",25.5D,"2010-10-01","燃油车"));
        cars.add(new Car(null,"1008","宝马A3",55.5D,"2014-10-01","燃油车"));
        cars.add(new Car(null,"1009","SUVt400",35.4D,"2017-10-01","新能源"));
        cars.add(new Car(null,"1010","红旗E8000",225.5D,"2001-10-01","燃油车"));

        int count = mapper.insertWithForEach(cars);
        System.out.println("成功插入" + count + "条数据");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids= {5L,6L};
        int count = carMapper.deleteByIds(ids);
        System.out.println("已删除" + count + "条数据");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectBySingleCondition(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        //仅执行第一个不为空的条件，且和后面得非空字段也都不参与查询
        List<Car> cars = carMapper.selectBySingleCondition(null, 10D,"燃油车");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testUpdateBySet(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        carMapper.updateBySet(new Car(4L,null,"宝骏H5",null,null,null));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByMultiConditionWithTrim(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = carMapper.selectByMultiConditionWithTrim("丰田",null,null);
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectByMultiConditionWithWhere(){
        SqlSession sqlSession  = SqlSessionUtil.openSqlSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = carMapper.selectByMultiConditionWithWhere("",null,"燃油车");

        cars.forEach(car -> System.out.println(car));
        sqlSession.close();

    }

    @Test
    public void testSelectByMultiCondition(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> carList = carMapper.selectByMultiCondition(null,20D,"燃油车");

        carList.forEach(car -> System.out.println(car));
        sqlSession.close();
    }
}
