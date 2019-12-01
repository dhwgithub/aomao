package com.henu.dao;

import com.henu.pojo.Car;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarMapper {
    int deleteByPrimaryKey(Integer cargood);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer cargood);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    Car findCarByCarGoodAndCaruser(Car car);

    int deleteCarByGidAndCid(Car car);

    int updateByCarGoodAndCaruser(Car car);

    Car selectByCarUser(String carUser);
}