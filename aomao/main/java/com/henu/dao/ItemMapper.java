package com.henu.dao;

import com.henu.pojo.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    int deleteByPrimaryKey(String iid);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(String iid);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    List<Item> selectAllItems();
}