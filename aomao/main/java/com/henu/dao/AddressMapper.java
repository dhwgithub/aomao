package com.henu.dao;

import com.henu.pojo.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
    int deleteByPrimaryKey(Integer addid);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer addid);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> selectAddressByAddruser(String addruser);
}