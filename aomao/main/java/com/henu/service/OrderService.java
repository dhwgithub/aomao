package com.henu.service;

import com.henu.dao.OrderMapper;
import com.henu.pojo.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService{

    @Resource
    private OrderMapper orderMapper;

    
    public int deleteByPrimaryKey(String oid) {
        return orderMapper.deleteByPrimaryKey(oid);
    }

    
    public int insert(Order record) {
        return orderMapper.insert(record);
    }

    
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    
    public Order selectByPrimaryKey(String oid) {
        return orderMapper.selectByPrimaryKey(oid);
    }

    
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    public List<Order> selectAllOrders() {return orderMapper.selectAllOrders();}

}
