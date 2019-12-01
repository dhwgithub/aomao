package com.henu.service;

import com.henu.dao.CarMapper;
import com.henu.pojo.Car;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CarService{

    @Resource
    private CarMapper carMapper;

    
    public int deleteByPrimaryKey(Integer cargood) {
        return carMapper.deleteByPrimaryKey(cargood);
    }

    
    public int insert(Car record) {
        return carMapper.insert(record);
    }

    
    public int insertSelective(Car record) {
        return carMapper.insertSelective(record);
    }

    
    public Car selectByPrimaryKey(Integer cargood) {
        return carMapper.selectByPrimaryKey(cargood);
    }

    
    public int updateByPrimaryKeySelective(Car record) {
        return carMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Car record) {
        return carMapper.updateByPrimaryKey(record);
    }

    public boolean addShopByUidAndGid(Car car){
        Car dbCar = carMapper.findCarByCarGoodAndCaruser(car);
        if(dbCar == null){
            if(carMapper.insert(car) == 1)
                return true;
            else
                return false;
        }else{
            dbCar.setCarnum(dbCar.getCarnum()+1);
            if(carMapper.updateByCarGoodAndCaruser(dbCar) == 1)
                return true;
            else
                return false;
        }
    }

    public Car selectByCarUser(String carUser){
        return carMapper.selectByCarUser(carUser);
    }
}
