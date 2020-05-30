package com.srqy.supersystem.manager.organ.service;

import com.srqy.supersystem.manager.organ.mapper.OrganMapper;
import com.srqy.supersystem.manager.organ.pojo.Organ;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: yww
 * @CreateTime: 2020/5/21
 */
@Service
public class OrganServiceImpl implements OrganService{

    @Resource
    private OrganMapper organMapper;

    @Override
    public List<Organ> findAll(Organ organ) {
        return organMapper.findAll(organ);
    }
}