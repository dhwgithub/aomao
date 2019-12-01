package com.henu.dao;

import com.henu.pojo.Goods;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;

public class GoodsMapperTest {
    private static GoodsMapper mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(GoodsMapperTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/GoodsMapperTestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(GoodsMapper.class, builder.openSession(true));
    }

    @Test
    public void testInsert() throws FileNotFoundException {
        Goods goods = new Goods();
        for(int i = 0; i < 40; i++) {
            goods.setGname(i + "德芙巧克力里脊芝士玉米粒街边烤玉米");
//                                香草味八喜芒果配糯米糖醋炸里脊黑椒
//                                德芙巧克力里脊芝士玉米粒街边烤玉米
            goods.setGclass(i+"食品");
            goods.setGduty(i+4.2);
            goods.setGnum(i+325);
            goods.setGpic("images/product"+(i%5+1)+".png");
            goods.setGprice(i+442.1);
            goods.setGprice2(i+5414.22);
            goods.setGsum(i+335);
            goods.setGtext(i+"一百里海底两万里德芙巧克力香草味八喜");
            goods.setGwei(i+512.78);
            mapper.insert(goods);
        }

    }
}
