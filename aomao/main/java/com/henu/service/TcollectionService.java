package com.henu.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.henu.dao.TcollectionMapper;
import com.henu.pojo.Tcollection;
@Service
public class TcollectionService{

    @Resource
    private TcollectionMapper tcollectionMapper;

    
    public int deleteByPrimaryKey(Integer cogood) {
        return tcollectionMapper.deleteByPrimaryKey(cogood);
    }

    
    public int insert(Tcollection record) {
        return tcollectionMapper.insert(record);
    }

    
    public int insertSelective(Tcollection record) {
        return tcollectionMapper.insertSelective(record);
    }

    
    public Tcollection selectByPrimaryKey(Integer cogood) {
        return tcollectionMapper.selectByPrimaryKey(cogood);
    }

    
    public int updateByPrimaryKeySelective(Tcollection record) {
        return tcollectionMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Tcollection record) {
        return tcollectionMapper.updateByPrimaryKey(record);
    }

}
