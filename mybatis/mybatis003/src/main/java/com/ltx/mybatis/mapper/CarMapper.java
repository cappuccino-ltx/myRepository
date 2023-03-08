package com.ltx.mybatis.mapper;

import com.ltx.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {

    /**
     * 使用foreach标签实现批量插入
     * @param cars 车辆信息数组
     * @return
     */
    int insertWithForEach(@Param("cars") List<Car> cars);

    /**
     * 使用foreach标签批量删除信息
     * @param ids id
     * @return
     */
    int deleteByIds(@Param("ids") Long[] ids);

    /**
     * 使用choose when otherwise 标签进行选择性单标签查询
     * @param brand 品牌
     * @param guidePrice 价格
     * @param carType 汽车种类
     * @return
     */
    List<Car> selectBySingleCondition(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    /**
     * 使用set标签实现对信息的修改
     * @param car 要修改的信息
     * @return
     */
    int updateBySet(Car car);

    /**
     * 使用trim标签进行多条件查询
     * @param brand 品牌
     * @param guidePrice 价格
     * @param carType 汽车类型
     * @return
     */
    List<Car> selectByMultiConditionWithTrim(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    /**
     * 使用where标签的多条件查询
     * @param brand 品牌
     * @param guidePrice 价格
     * @param carType 汽车类型
     * @return
     */
    List<Car> selectByMultiConditionWithWhere(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    /**
     * 多条件查询（if标签）
     * @param brand 品牌
     * @param guidePrice 价格
     * @param carType 汽车类型
     * @return
     */
    //基于品牌brand,价格guide_price,汽车种类car_type的多条件查询
    List<Car> selectByMultiCondition(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);
}
