package com.srqy.supersystem.manager.user.pojo;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yww
 * @CreateTime: 2020/5/16
 */
@TableName("t_person")//mybatisplus提供的表名映射注解
public class User implements Serializable {

    private static final long serialVersionUID = -4164552438788291998L;

//  @TableId  当实体与数据库主键不一致时,通过tableId注解识别主键
    private String id;//人员id
    @TableField(condition = SqlCondition.LIKE)//使用对象作为queryWarpper参数式,修改为like查询,也可以自定义@TableField(condition = "   ")
    private String name;//人员名称
    private String password;//密码
    @TableField("orgid")
    private String orgId;//部门id
    private String phone;//电话号码
    private String email;//邮箱
    private Integer status;//状态  1-存在  9-删除
    private String creator;//创建人
    @TableField("createTime")
    private Date createTime;//创建时间

    @TableField(exist = false)//该注解默认为true,自动映射表数据库列名,false代表数据库中没有此字段
    private String orgName;//

    public User() {
    }

    public User(String id, String name, String password, String orgId,String phone, String email, Integer status, String creator, Date createTime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.orgId = orgId;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.creator = creator;
        this.createTime = createTime;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", orgId='" + orgId + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", orgName='" + orgName + '\'' +
                '}';
    }
}