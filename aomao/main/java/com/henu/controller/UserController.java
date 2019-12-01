package com.henu.controller;

import com.henu.pojo.User;
import com.henu.service.UserService;
import com.henu.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    /* 个人中心 */
    @ResponseBody
    @RequestMapping("/accMyIndex")
    public Msg accMyIndex(HttpSession session){
        User user = ((User)session.getAttribute("getUser"));
        if(user  == null){
            return Msg.fail().setMsg("请登录！");
        }
        return Msg.success().add("user", user);
    }

    /* 用户注册 */
    @ResponseBody
    @RequestMapping("/userRegister")
    public Msg userRegister(User user, String code, HttpSession session){
        /* 验证码检验 */
        if(checkCode(code, session) == false){
            return Msg.fail().setMsg("验证码输入错误，请重新输入！");
        }

        if(userService.selectByEmail(user.getUemail()) != null || userService.insert(user) == 0){
            return Msg.fail().setMsg("账号已存在，请重新注册！");
        }
        return Msg.success().setMsg("注册成功，请登录！");
    }

    /* 判断用户是否登录 */
    @ResponseBody
    @RequestMapping("/isLogin")
    public Msg isLogin(HttpSession session){
        User user = (User)session.getAttribute("getUser");
        if(user == null){
            return Msg.fail().setMsg("请登录！");
        }else{
            return Msg.success().add("userName", user.getUname());
        }
    }

    /* 登录 */
    @ResponseBody
    @RequestMapping("/userLogin")
    public Msg login(User user, String code, String isremember,
                     HttpSession session,
                     HttpServletRequest request, HttpServletResponse response) {

        /* 验证码检验 */
        if(checkCode(code, session) == false){
            return Msg.fail().setMsg("验证码输入错误，请重新输入！");
        }

        /* 用户验证 */
        User getUser = userService.selectByEmail(user.getUemail());
        if (user.getUemail() != null && user.getUpwd() != null &&
                user.getUemail().trim().length() != 0 && user.getUpwd().trim().length() != 0 &&
                getUser.getUpwd().equals(user.getUpwd())) {
            session.setAttribute("getUser", getUser);

            /* 记住账号 */
            if("remember".equals(isremember)) {
                //创建cookie(不能为中文)
                Cookie cookie = new Cookie("remember", user.getUemail());
                cookie.setPath(request.getContextPath()+"/");
                cookie.setMaxAge(3600);
                //写回浏览器
                response.addCookie(cookie);
            }

            return Msg.success().setMsg("登录成功！");
        } else {
            return Msg.fail().setMsg("邮箱或密码错误，请重新输入！");
        }
    }

    /* 验证码检验 */
    public boolean checkCode(String code, HttpSession session){
        String sessionCode = (String)session.getAttribute("sessionCode");
        session.removeAttribute("sessionCode");
        if (sessionCode == null) {
            return false;
        }
        if(code == null || code.trim().length() == 0 ||
                code.equalsIgnoreCase(sessionCode) == false){
            return false;
        }
        return true;
    }

    /* 以下均为跳转页面操作 */
    @RequestMapping("/toLogin")
    public String toLogin(){return "login";}
    @RequestMapping("/toList")
    public String toList(){return "list";}
    @RequestMapping("/toUserRegister")
    public String toUserRegister(){return "register";}
    @RequestMapping("/toAllOrder")
    public String toAllOrder(){return "allOrder";}
    @RequestMapping("/toCardToOrder")
    public String toCardToOrder(){return "CardToOrder";}
    @RequestMapping("/toCart")
    public String toCart(){return "Cart";}
    @RequestMapping("/toPay")
    public String toPay(){return "pay";}
    @RequestMapping("/toPaysuccess")
    public String toPaysuccess(){return "paysuccess";}
    @RequestMapping("/toShopShow")
    public String toShopShow(){return "shopShow";}
    @RequestMapping("/toMyIndex")
    public String toMyIndex(){return "myIndex";}
    @RequestMapping("/toUserSet")
    public String toUserSet() {return "userSet";}
    @RequestMapping("/toAdmin")
    public String toAdmin() {return "admin";}
    @RequestMapping("/toAddGift")
    public String toAddGift() {return "addGift";}
    @RequestMapping("/toGiftSet")
    public String toGiftSet() {return "giftSet";}
    @RequestMapping("/toadminLogin")
    public String toadminLogin() {return "adminLogin";}
}
