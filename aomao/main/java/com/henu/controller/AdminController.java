package com.henu.controller;

import com.henu.pojo.Admin;
import com.henu.service.AdminService;
import com.henu.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 管理员登录
     * @param adm 管理员信息
     * @param session session值
     * @return msg:
     */
    @ResponseBody
    @RequestMapping("/adminLogin")
    public Msg login(Admin adm, HttpSession session, HttpServletResponse response){
        if (adm.getAdmuser().isEmpty() || adm.getAdmpwd().isEmpty()){
            return Msg.fail().setMsg("账号密码不能为空");
        }else{
            Admin admin = adminService.selectAdminByAdmuser(adm.getAdmuser());
            if(admin.getAdmpwd().equals(adm.getAdmpwd())){
                //登录成功，将admin对象设置到HttpSession作用范围域中
                session.setAttribute("admin", admin);
                return Msg.success();
            }else {
                return Msg.fail().setMsg("不存在此管理员");
            }
        }
    }
//    @RequestMapping("/toadminLogin")
//    public String toadminLogin(){
//        return "adminLogin";
//    }

//    @RequestMapping("/toAdmin")
//    public String toAdmin(){
//        return "admin";
//    }

    @RequestMapping("/toUpdate")
    public String toUpdate(){
        return "updateAdmin";
    }
    /**
     * 所有管理员展示
     * @param model
     * @return
     */
    @RequestMapping("/listAdmin")
    public String list(Model model){
        List<Map<String, Object>> adminList = adminService.selectAll();
        model.addAttribute("list",adminList);
        //转发到jsp界面
        return "admin";
    }

    /**
     * 所有管理员展示
     * @param model
     * @return
     */
    @RequestMapping("/listAdminTwo")
    public String listTwo(Model model){
        List<Map<String, Object>> adminList = adminService.selectAll();
        model.addAttribute("list",adminList);
        //转发到jsp界面
        return "updateAdmin";
    }
    /**
     * 增加管理员
     * @param admin 管理员信息
     * @param httpSession
     * @param response
     * @return msg：成功Or错误信息
     */
    @RequestMapping("/addAdmin")
    public Msg addManagerUser(Admin admin,HttpSession httpSession,HttpServletResponse response){
        //判断权限，只有超级管理员可以增加普通管理员
        System.out.println(admin);
        Admin adminLogin =  (Admin)httpSession.getAttribute("admin");
        if(adminLogin.getAdmuser().equals("root")){//当前登录用户为超级管理员
            //判断是否已添加过此管理员
            if(adminService.selectByadmuser(admin.getAdmuser())==null){ //不存在此管理员信息则添加
                adminService.insert(admin);
                return Msg.success();
            }else {  //存在此管理员则提示不能添加
                return Msg.fail().setMsg("不能重复添加");
            }
        }else{
            return Msg.fail().setMsg("没有权限");
        }
    }

//    /**
//     * 删除普通管理员
//     * @return msg：成功Or错误信息
//     ** @param httpSession
//     */
//    @RequestMapping(value = "/deleteAdmin/{admid}")
//    public Msg deleteAdminUser(@PathVariable Integer admid,HttpSession httpSession,HttpServletResponse response){
//        //判断权限，只有超级管理员可以删除普通管理员
//        System.out.println(admid);
//        Admin adminLogin =  (Admin)httpSession.getAttribute("admin");
//        if(adminLogin.getAdmuser().equals("root")){//当前登录账户超级管理员
//            //超级管理员不可删除，只能删除普通管理员
//            if(adminService.selectByPrimaryKey(admid).getAdmuser().equals("root")){ //若用户名为root即为超级管理员
//                return Msg.fail().setMsg("超级管理员不可删除！");
//            }else{
//                adminService.deleteByPrimaryKey(admid);
//                return Msg.success();
//            }
//        }else{
//            return Msg.fail().setMsg("没有权限！");
//        }
//
//    }
    /**
     * 删除普通管理员
     * @return msg：成功Or错误信息
     ** @param httpSession
     */
    @RequestMapping(value = "/deleteAdmin/{admid}")
    public String deleteAdminUser(@PathVariable Integer admid,HttpSession httpSession,HttpServletResponse response){
        //判断权限，只有超级管理员可以删除普通管理员
        System.out.println(admid);
        Admin adminLogin =  (Admin)httpSession.getAttribute("admin");
        if(adminLogin.getAdmuser().equals("root")){//当前登录账户超级管理员
            //超级管理员不可删除，只能删除普通管理员
            if(adminService.selectByPrimaryKey(admid).getAdmuser().equals("root")){ //若用户名为root即为超级管理员
                return "admin";
            }else{
                adminService.deleteByPrimaryKey(admid);
                return "admin";
            }
        }else{
            return "admin";
        }

    }
    /**
     * 修改管理员
     * @param admin 个人信息
     @param httpSession
     * @return
     */
    @RequestMapping(value={"/updateAdmin"})
    public String updateAdminUser(Admin admin,HttpSession httpSession,Model model){
        //判断权限，只有超级管理员可以修改普通管理员
        System.out.println(admin);
        Admin adminLogin =  (Admin)httpSession.getAttribute("admin");
        if(adminLogin.getAdmuser().equals("root")){
            adminService.updateAdminByPrimaryKey(admin.getAdmuser());
            return "updateAdmin";
        }else {
            return "updateAdmin";
        }
    }

    @RequestMapping("/searchAdmin")
    public String searchAdmin(String admname,HttpServletRequest request, Model model){
        System.out.println(admname);
        List<Map<String, Object>> adminList = adminService.searchAdmin(admname);
        model.addAttribute("list",adminList);
        //转发到jsp界面
        return "searchAdmin";
    }
}
