package com.henu.controller;

import com.henu.pojo.Item;
import com.henu.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@Controller
public class ItemController {
    private ServletConfig servletConfig;

    public void setServletConfig(ServletConfig servletConfig) {
        this.servletConfig = servletConfig;
    }
    @Autowired
    ItemService itemService;

    private int perPageSize = 12; //每页个数
    private int navigatePages = 5; //导航页个数
//    private String key = "Ori"; //分类

    /* 分页查询 */


    @RequestMapping(value="/selectAllItems")
    public String selectAllItems(@RequestParam("f") String f, Model model) throws ServletException, IOException {
        System.out.println("进入");
        List<Item> items =  itemService.selectAllItems();
        System.out.println(items.get(0).getIid());

        model.addAttribute("items", items);
        if("1".equals(f))
            return "orderList";
        else return null;
    }

}
