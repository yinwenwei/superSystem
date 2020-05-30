package com.srqy.supersystem.interceptor;

import com.srqy.supersystem.manager.user.pojo.User;
import com.srqy.supersystem.tools.Share;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * @Author: yww
 * @CreateTime: 2020/5/22
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("拦截器执行");
        try {
            User user = (User) request.getSession().getAttribute("loginUser");
            if(!Share.isEmpty(user)){//不为空,放行
                return true;
            }
            response.sendRedirect(request.getContextPath()+"/sys/login.html");
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("postHandle 方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("afterCompletion 方法");
    }
}