package com.henu.service;

import com.henu.dao.AddressMapper;
import com.henu.pojo.Address;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressService{

    @Resource
    private AddressMapper addressMapper;

    
    public int deleteByPrimaryKey(Integer addid) {
        return addressMapper.deleteByPrimaryKey(addid);
    }

    
    public int insert(Address record) {
        return addressMapper.insert(record);
    }

    
    public int insertSelective(Address record) {
        return addressMapper.insertSelective(record);
    }

    
    public Address selectByPrimaryKey(Integer addid) {
        return addressMapper.selectByPrimaryKey(addid);
    }

    
    public int updateByPrimaryKeySelective(Address record) {
        return addressMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Address record) {
        return addressMapper.updateByPrimaryKey(record);
    }

    public List<Address> selectAddressByUser(String addruser){return addressMapper.selectAddressByAddruser(addruser);}
}
