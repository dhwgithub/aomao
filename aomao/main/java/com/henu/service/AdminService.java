package com.henu.service;

import com.henu.dao.AdminMapper;
import com.henu.pojo.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AdminService{

    @Resource
    private AdminMapper adminMapper;

    /**
     * 删除管理员
     * @param admid 管理员id
     * @return 1
     */
    public int deleteByPrimaryKey(Integer admid) {
        return adminMapper.deleteByPrimaryKey(admid);
    }

    
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    
    public Admin selectByPrimaryKey(Integer admid) {
        return adminMapper.selectByPrimaryKey(admid);
    }

    
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据管理员账号查询整条数据
     * @param admuser 管理员账号
     * @return 整条数据
     */
    public  Admin selectByadmuser (String admuser){
        return adminMapper.selectByadmuser(admuser);
    }

    /**
     * 登录
     * @param admuser 账号
     * @return
     */
    public Admin selectAdminByAdmuser(String admuser){
        return adminMapper.selectAdminByAdmuser(admuser);
    }

    /**
     * 查询所有管理员
     * @return 多个Admin对象
     */
    public List<Map<String, Object>> selectAll(){
        return adminMapper.selectAll();
    }

    public int updateAdminByPrimaryKey(String admuser) {
        return adminMapper.updateAdminByPrimaryKey(admuser);
    }

    public List<Map<String,Object>> searchAdmin(String admname){
        return adminMapper.searchAdmin(admname);
    }


}
