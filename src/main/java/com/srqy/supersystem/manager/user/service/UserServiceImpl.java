package com.srqy.supersystem.manager.user.service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.srqy.supersystem.manager.user.mapper.UserMapper;
import com.srqy.supersystem.manager.user.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: yww
 * @CreateTime: 2020/5/19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String name, String pwd) {
        return userMapper.login(name,pwd);
    }


}