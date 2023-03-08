package com.ltx.mybatis.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {
    /**
     * car的实体类
     * 属性：
     *      bigint id(主键)
     *      varchar car_num(编号)
     *      varchar brand(品牌型号)
     *      decimal guide_price(价格)
     *      varchar produce_time(生产时间)
     *      varchar car_type(汽车类型)
     */
    private Long id;
    private String carNum;
    private String brand;
    private Double guidePrice;
    private String ProduceTime;
    private String carType;


    public Car(Long id, String carNum, String brand, Double guidePrice, String produceTime, String carType) {
        this.id = id;
        this.carNum = carNum;
        this.brand = brand;
        this.guidePrice = guidePrice;
        ProduceTime = produceTime;
        this.carType = carType;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(Double guidePrice) {
        this.guidePrice = guidePrice;
    }

    public String getProduceTime() {
        return ProduceTime;
    }

    public void setProduceTime(String produceTime) {
        ProduceTime = produceTime;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(carNum, car.carNum) && Objects.equals(brand, car.brand) && Objects.equals(guidePrice, car.guidePrice) && Objects.equals(ProduceTime, car.ProduceTime) && Objects.equals(carType, car.carType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carNum, brand, guidePrice, ProduceTime, carType);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carNum='" + carNum + '\'' +
                ", brand='" + brand + '\'' +
                ", guidePrice=" + guidePrice +
                ", ProduceTime='" + ProduceTime + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }
}
