package com.henu.controller;

import com.henu.pojo.Car;
import com.henu.pojo.User;
import com.henu.service.CarService;
import com.henu.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class CarController {

    @Autowired
    CarService carService;

    /* 购物车加载 */
    @ResponseBody
    @RequestMapping("/getCarByUserAndGoods")
    public Msg getCarByUserAndGoods(HttpSession session){
        User user = (User)session.getAttribute("getUser");

        Car car = carService.selectByCarUser(user.getUid());

        return Msg.success().add("getCar", car);
    }

    /* 添加到购物车 */
    @ResponseBody
    @RequestMapping("/addCarByGid")
    public Msg addCarByGid(String gid, HttpSession session){

        User user = (User)session.getAttribute("getUser");

        if(user == null){
            return Msg.fail().setMsg("请登录后再购物~");
        }else{
            String uid = user.getUid();
            Car car = new Car();
            car.setCargood(Integer.parseInt(gid));
            car.setCarnum(1);
            car.setCaruser(uid);
            if(carService.addShopByUidAndGid(car) == true){
                return Msg.success().setMsg("成功加入购物车！");
            }else{
                return Msg.fail().setMsg("加入购物车失败！");
            }
        }
    }
}
