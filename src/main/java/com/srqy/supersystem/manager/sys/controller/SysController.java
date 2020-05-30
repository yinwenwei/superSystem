package com.srqy.supersystem.manager.sys.controller;

import com.srqy.supersystem.base.BaseController;
import com.srqy.supersystem.manager.user.pojo.User;
import com.srqy.supersystem.tools.JsonData;
import com.srqy.supersystem.tools.Share;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author: yww
 * @CreateTime: 2020/5/16
 */
@Controller
@RequestMapping("/sys")
public class SysController extends BaseController {

    //登录界面
    @RequestMapping("/login.html")
    public String login(){
        return "common/login";
    }


    //登录方法
    @RequestMapping("/login.do")
    @ResponseBody
    public JsonData loginDo(String name, String pwd, HttpSession session){
        JsonData jsonData = new JsonData();
        try {
            User user = userService.login(name, pwd);
            if(!Share.isEmpty(user)){
                session.setAttribute("loginUser",user);
                session.setMaxInactiveInterval(30*60);//半小时session失效
                return jsonData.bind(true,"登录成功");
            }
            return jsonData.bind(false,"用户名或密码错误！");
        }catch(Exception e){
            e.printStackTrace();
            return jsonData.bind(false,"系统出错,请联系管理员！");
        }
    }


    //退出登录
    @RequestMapping("/loginOut.do")
    @ResponseBody
    public JsonData loginOut(HttpSession session){
        JsonData jsonData = new JsonData();
        try {
            session.invalidate();//清除session中所有属性
            return jsonData.bind(true,"退出成功！");
        }catch (Exception e){
            e.printStackTrace();
            return jsonData.bind(false,"系统出错,请联系管理员！");
        }
    }


    //后台界面
    @RequestMapping("/index.html")
    public String index(){
        return "common/index";
    }


    //后台首页界面
    @RequestMapping("/home.html")
    public String home(){
        return "common/home";
    }

    //404
    @RequestMapping("/404.html")
    public String notFind(){

        return "common/404";
    }

}