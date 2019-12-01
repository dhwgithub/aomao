package com.henu.dao;

import com.henu.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

//    /* 查询当前页商品 */
//    List<Goods> getCurrPageGoods(PageElement pageElement);
//
//    /* 查询商品总数 */
//    int getAllGoodsNum();

    List<Goods> findGoodsLikeKey(@Param("key") String key);

    List<Goods> selectAllGoods();
}