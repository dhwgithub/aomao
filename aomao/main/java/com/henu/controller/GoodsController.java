package com.henu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.henu.pojo.Goods;
import com.henu.service.GoodsService;
import com.henu.util.Msg;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class GoodsController  implements ServletConfigAware {
    private ServletConfig servletConfig;

    public void setServletConfig(ServletConfig servletConfig) {
        this.servletConfig = servletConfig;
    }

    @Autowired
    GoodsService goodsService;

    private int perPageSize = 12; //每页个数
    private int navigatePages = 5; //导航页个数
//    private String key = "Ori"; //分类

    /* 商品详情展示 */
    @RequestMapping("/getGoodsDetail")
    public String getGoodsDetail(@Param("gid") String gid, Model model){
        System.out.println(gid);
        Goods goodsDetail = goodsService.selectByPrimaryKey(Integer.parseInt(gid));
        model.addAttribute("goodsDetail", goodsDetail);
        return "shopShow";
    }


    /* 分页查询 */
    @ResponseBody
    @RequestMapping("/getAllGoodsWithOri")
    public Msg getAllGoodsWithOri(int currentPage, String keyName){
        //使用分页插件,核心代码就这一行，当前页数、每页个数
        PageHelper.startPage(currentPage, perPageSize);

        List<Goods> goodsLikeKey = goodsService.findGoodsLikeKey(keyName);

        PageInfo<Goods> pg = new PageInfo<>(goodsLikeKey, navigatePages);

        return Msg.success().add("goodsPageList", pg);
    }





    @RequestMapping(value="/addGift")
    public String addGift(@RequestParam("gPic") CommonsMultipartFile file, String gName, String gPrice, String gSum, String gNum, String gPrice2, String gWei, String gDuty, String gClass) throws ServletException, IOException {
        System.out.println("进入");
        long  startTime=System.currentTimeMillis();
        System.out.println("fileName："+file.getOriginalFilename());
        String path="D:/java/upload/"+new Date().getTime()+file.getOriginalFilename();

        File newFile=new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        long  endTime=System.currentTimeMillis();
        System.out.println("方法二的运行时间："+String.valueOf(endTime-startTime)+"ms");

        System.out.println("gsum:"+gSum);
        System.out.println("gsum:"+Integer.parseInt(gSum));
        System.out.println("gNum"+gNum);
        Goods good = new Goods();
        good.setGname(gName);
        good.setGprice(Double.parseDouble(gPrice));
        good.setGsum(Integer.parseInt(gSum));
        good.setGnum(Integer.parseInt(gNum));
        good.setGprice2(Double.parseDouble(gPrice2));
        good.setGwei(Double.parseDouble(gWei));
        good.setGduty(Double.parseDouble(gDuty));
        good.setGpic("/upload/"+file.getOriginalFilename());
        System.out.println(good.getGwei());
        int n = goodsService.insert(good);
        return "/list";
    }
    @RequestMapping(value="/selectAllGoods")
    public String selectAllGift(@RequestParam("f") String f, Model model) throws ServletException, IOException {
        System.out.println("进入");
        List<Goods> goods =  goodsService.selectAllGoods();
        System.out.println(goods.get(0).getGname());

        model.addAttribute("goods", goods);
        if("1".equals(f))
            return "giftList";
        else return null;
    }
    @RequestMapping(value="/selectByPrimaryKey")
    public String selectByPrimaryKey(@RequestParam("f") String f, int gid, Model model) throws ServletException, IOException {
        System.out.println("进入");
        Goods good =  goodsService.selectByPrimaryKey(gid);
        System.out.println(good.getGname());

        model.addAttribute("good", good);
        if("1".equals(f))
            return "giftSet";
        else return null;
    }
    @RequestMapping(value="/updateGood")
    public ModelAndView updateGood(@RequestParam("gPic") CommonsMultipartFile file, String gName, String gPrice, String gSum, String gNum, String gPrice2, String gWei, String gDuty, String gClass, int gid) throws ServletException, IOException {
        System.out.println("进入");
        long  startTime=System.currentTimeMillis();
        System.out.println("fileName："+file.getOriginalFilename());
        String path="D:/java/upload/"+new Date().getTime()+file.getOriginalFilename();

        File newFile=new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        long  endTime=System.currentTimeMillis();
        System.out.println("方法二的运行时间："+String.valueOf(endTime-startTime)+"ms");

        System.out.println("gsum:"+gSum);
        System.out.println("gsum:"+Integer.parseInt(gSum));
        System.out.println("gNum"+gNum);
        Goods good = goodsService.selectByPrimaryKey(gid);
        good.setGname(gName);
        good.setGprice(Double.parseDouble(gPrice));
        good.setGsum(Integer.parseInt(gSum));
        good.setGnum(Integer.parseInt(gNum));
        good.setGprice2(Double.parseDouble(gPrice2));
        good.setGwei(Double.parseDouble(gWei));
        good.setGduty(Double.parseDouble(gDuty));
        good.setGpic("/upload/"+file.getOriginalFilename());
        System.out.println(good.getGwei());
        int n = goodsService.updateByPrimaryKey(good);
        System.out.println("n: " + n);
//        Model model = null;
//        model.addAttribute("good",good);
        return new ModelAndView("redirect:/selectAllGoods?f=1");

        //return selectAllGift("1", model);
    }
    @RequestMapping("deleteGood")
    public ModelAndView deleteGood(@RequestParam("f") String f, int gid) {
        System.out.println("进入删除商品界面");
        int n = goodsService.deleteByPrimaryKey(gid);
        if(n > 0) {
            if("1".equals(f)) {
                return new ModelAndView("redirect:/selectAllGoods?f=1");
            }
        }
        return null;
    }
}
