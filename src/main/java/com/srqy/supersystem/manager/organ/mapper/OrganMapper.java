package com.srqy.supersystem.manager.organ.mapper;

import com.srqy.supersystem.manager.organ.pojo.Organ;

import java.util.List;

/**
 * @Author: yww
 * @CreateTime: 2020/5/16
 */
public interface OrganMapper{
    List<Organ> findAll(Organ organ);

}
