package com.srqy.supersystem.manager.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.srqy.supersystem.base.BaseController;
import com.srqy.supersystem.manager.user.pojo.User;
import com.srqy.supersystem.tools.pageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: yww
 * @CreateTime: 2020/5/16
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @RequestMapping("/list.html")
    public String list(){
        return "user/userList";
    }

    @RequestMapping("/pageList.do")
    @ResponseBody
    public pageBean pageList(Integer page, Integer limit, User user){

        IPage<User> userpagelist = userService.page(new Page<>(page, limit), new QueryWrapper<User>().setEntity(user));

        return new pageBean("0","",userpagelist.getTotal(),userpagelist.getRecords());
    }

}