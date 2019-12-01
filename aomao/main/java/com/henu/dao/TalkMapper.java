package com.henu.dao;

import com.henu.pojo.Talk;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TalkMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Talk record);

    int insertSelective(Talk record);

    Talk selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Talk record);

    int updateByPrimaryKey(Talk record);
}