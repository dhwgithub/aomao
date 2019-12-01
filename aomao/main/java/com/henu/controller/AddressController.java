package com.henu.controller;

import com.henu.pojo.Address;
import com.henu.pojo.User;
import com.henu.service.AddressService;
import com.henu.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AddressController {

    @Autowired
    AddressService addressService;

    /* 添加收货地址 */
    @ResponseBody
    @RequestMapping("/addAddressByUser")
    public Msg addAddressByUser(Address address, HttpSession session){
        address.setAddruser(((User)session.getAttribute("getUser")).getUid());
        System.out.println(address);
        if(addressService.insert(address) == 1){
            return Msg.success().setMsg("添加成功！");
        }else{
            return Msg.fail().setMsg("插入失败！");
        }
    }

    /* 获取收货地址 */
    @ResponseBody
    @RequestMapping("/getAddressByUser")
    public Msg getAddressByUser(HttpSession session){
        User user = (User)session.getAttribute("getUser");

        if(user == null){
            return Msg.fail().setMsg("请登录后再购物~");
        }else{
            List<Address> addressList = addressService.selectAddressByUser(user.getUid());
            if(addressList != null){
                return Msg.success().add("addressList", addressList);
            }else{
                return Msg.fail().setMsg("暂无地址，请添加！");
            }
        }
    }

}
