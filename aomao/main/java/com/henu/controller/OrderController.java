package com.henu.controller;

import com.henu.dao.OrderMapper;
import com.henu.pojo.Order;
import com.henu.service.OrderService;
import com.henu.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@Controller
public class OrderController {
    private ServletConfig servletConfig;

    public void setServletConfig(ServletConfig servletConfig) {
        this.servletConfig = servletConfig;
    }

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderService orderService;


    @ResponseBody
    @RequestMapping("/sendOrderByInfo")
    public Msg sendOrderByInfo(){
        return Msg.success();
    }

    @RequestMapping("selectAllOrders")
    public String selectAllOrders(String f, Model model) {
        System.out.println("进入查询所有订单");
        List<Order> orders =  orderService.selectAllOrders();
        System.out.println(orders.get(0).getOid());

        model.addAttribute("orders", orders);
        if("1".equals(f))
            return "orderList";
        else return null;
    }
    @RequestMapping(value="/selectOrderByPrimaryKey")
    public String selectOrderByPrimaryKey(@RequestParam("f") String f, String oid, Model model) throws ServletException, IOException {
        System.out.println("进入");
        Order order =  orderService.selectByPrimaryKey(oid);
        System.out.println(order.getOid());

        model.addAttribute("order", order);
        if("1".equals(f))
            return "orderSet";
        else return null;
    }
}
