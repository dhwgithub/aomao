package com.henu.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.henu.dao.TalkMapper;
import com.henu.pojo.Talk;
@Service
public class TalkService{

    @Resource
    private TalkMapper talkMapper;

    
    public int deleteByPrimaryKey(Integer tid) {
        return talkMapper.deleteByPrimaryKey(tid);
    }

    
    public int insert(Talk record) {
        return talkMapper.insert(record);
    }

    
    public int insertSelective(Talk record) {
        return talkMapper.insertSelective(record);
    }

    
    public Talk selectByPrimaryKey(Integer tid) {
        return talkMapper.selectByPrimaryKey(tid);
    }

    
    public int updateByPrimaryKeySelective(Talk record) {
        return talkMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Talk record) {
        return talkMapper.updateByPrimaryKey(record);
    }

}
