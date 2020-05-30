package com.srqy.supersystem.tools;

import java.util.List;

/**
 * layui分页返回格式
 * @Author: yww
 * @CreateTime: 2020/5/23
 */
public class pageBean {
    private String code;
    private String msg;
    private Long count;
    private List data;

    public pageBean() {
    }

    public pageBean(String code, String msg, Long count, List data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}