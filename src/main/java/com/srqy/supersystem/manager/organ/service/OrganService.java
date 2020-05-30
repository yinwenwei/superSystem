package com.srqy.supersystem.manager.organ.service;

import com.srqy.supersystem.manager.organ.pojo.Organ;

import java.util.List;

/**
 * @Author: yww
 * @CreateTime: 2020/5/21
 */
public interface OrganService{
    List<Organ> findAll(Organ organ);
}
