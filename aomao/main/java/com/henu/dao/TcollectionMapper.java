package com.henu.dao;

import com.henu.pojo.Tcollection;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TcollectionMapper {
    int deleteByPrimaryKey(Integer cogood);

    int insert(Tcollection record);

    int insertSelective(Tcollection record);

    Tcollection selectByPrimaryKey(Integer cogood);

    int updateByPrimaryKeySelective(Tcollection record);

    int updateByPrimaryKey(Tcollection record);
}