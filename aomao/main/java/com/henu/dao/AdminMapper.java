package com.henu.dao;

import com.henu.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
    int deleteByPrimaryKey(Integer admid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer admid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin selectByadmuser(String admuser);

    Admin selectAdminByAdmuser(String admuser);

    List<Map<String, Object>> selectAll();

    int updateAdminByPrimaryKey(String admuser);

    List<Map<String, Object>> searchAdmin(String admname);
}