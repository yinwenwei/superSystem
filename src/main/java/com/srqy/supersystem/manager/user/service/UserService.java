package com.srqy.supersystem.manager.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.srqy.supersystem.manager.user.pojo.User;

import java.util.List;

/**
 * @Author: yww
 * @CreateTime: 2020/5/19
 */
public interface UserService extends IService<User> {

    User login(String name,String pwd);

}
