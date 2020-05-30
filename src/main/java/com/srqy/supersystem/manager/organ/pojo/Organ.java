package com.srqy.supersystem.manager.organ.pojo;

import org.springframework.context.annotation.Bean;

import java.io.Serializable;

/**
 * @Author: yww
 * @CreateTime: 2020/5/16
 */
public class Organ implements Serializable {

    private static final long serialVersionUID = 2277330157727042546L;

    private String id;
    private String orgName;
    private String remark;
    private String orgType;//机构类型
    private String parentId;//父id
    private Integer seq;//排序
    private Integer status;//状态

    public Organ() {
    }

    public Organ(String id, String orgName, String remark, String orgType, String parentId, Integer seq, Integer status) {
        this.id = id;
        this.orgName = orgName;
        this.remark = remark;
        this.orgType = orgType;
        this.parentId = parentId;
        this.seq = seq;
        this.status = status;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}