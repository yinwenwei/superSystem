package com.srqy.supersystem.manager.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.srqy.supersystem.manager.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: yww
 * @CreateTime: 2020/5/16
 */
public interface UserMapper extends BaseMapper<User> {

    User login(@Param("name") String name, @Param("pwd") String pwd);

}
