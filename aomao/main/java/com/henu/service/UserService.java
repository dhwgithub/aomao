package com.henu.service;

import com.henu.dao.UserMapper;
import com.henu.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserService{

    @Resource
    private UserMapper userMapper;

    
    public int deleteByPrimaryKey(String uid) {
        return userMapper.deleteByPrimaryKey(uid);
    }

    
    public int insert(User record) {
        return userMapper.insert(record);
    }

    
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    
    public User selectByPrimaryKey(String uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    public User selectByEmail(String uemail){
        return userMapper.selectByEmail(uemail);
    }

}
