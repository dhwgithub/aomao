package com.henu.service;

import com.henu.dao.GoodsMapper;
import com.henu.pojo.Goods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsService{

    @Resource
    private GoodsMapper goodsMapper;

    
    public int deleteByPrimaryKey(Integer gid) {
        return goodsMapper.deleteByPrimaryKey(gid);
    }

    
    public int insert(Goods record) {
        return goodsMapper.insert(record);
    }

    
    public int insertSelective(Goods record) {
        return goodsMapper.insertSelective(record);
    }

    
    public Goods selectByPrimaryKey(Integer gid) {
        return goodsMapper.selectByPrimaryKey(gid);
    }

    
    public int updateByPrimaryKeySelective(Goods record) {
        return goodsMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Goods record) {
        return goodsMapper.updateByPrimaryKey(record);
    }

//    /* 分页查询 */
//    public PageBean<Goods> findGoodsList(Integer currPage, Integer perPageSize, String key){
//        List<Goods> newPageList = null;
//        int totalCount = 0;
//        int currPages = (currPage-1)*perPageSize;
//        PageElement pageElement = new PageElement();
//        if("Ori".equals(key)){ //默认分类
//            pageElement.setCurrPage(currPage);
//            pageElement.setPerPageSize(perPageSize);
//            newPageList = goodsMapper.getCurrPageGoods(pageElement);
//            totalCount = goodsMapper.getAllGoodsNum();
//
//        }
//
//        return new PageBean<>(newPageList, currPage, perPageSize, totalCount);
//    }

    public List<Goods> findGoodsLikeKey(String key) {
        return goodsMapper.findGoodsLikeKey(key);
    }

    public List<Goods> selectAllGoods() {
        return goodsMapper.selectAllGoods();
    }
}
