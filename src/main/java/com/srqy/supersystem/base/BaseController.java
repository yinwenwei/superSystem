package com.srqy.supersystem.base;

import com.srqy.supersystem.manager.organ.service.OrganService;
import com.srqy.supersystem.manager.user.pojo.User;
import com.srqy.supersystem.manager.user.service.UserService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: yww
 * @CreateTime: 2020/5/18
 */
public class BaseController{

    @Resource
    protected UserService userService;//人员
    @Resource
    protected OrganService organService;//机构

    /**
     * 获取当前登录人员
     * @return
     */
    public User getLoginUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return (User) request.getSession().getAttribute("loginUser");
    }

}