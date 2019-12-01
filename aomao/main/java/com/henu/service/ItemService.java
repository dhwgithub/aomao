package com.henu.service;

import com.henu.dao.ItemMapper;
import com.henu.pojo.Item;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemService{

    @Resource
    private ItemMapper itemMapper;

    
    public int deleteByPrimaryKey(String iid) {
        return itemMapper.deleteByPrimaryKey(iid);
    }

    
    public int insert(Item record) {
        return itemMapper.insert(record);
    }

    
    public int insertSelective(Item record) {
        return itemMapper.insertSelective(record);
    }

    
    public Item selectByPrimaryKey(String iid) {
        return itemMapper.selectByPrimaryKey(iid);
    }

    
    public int updateByPrimaryKeySelective(Item record) {
        return itemMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Item record) {
        return itemMapper.updateByPrimaryKey(record);
    }

    public List<Item> selectAllItems() {
        return itemMapper.selectAllItems();
    }
}
