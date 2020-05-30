package com.srqy.supersystem.tools;

import java.io.Serializable;

/**
 * @Author: yww
 * @CreateTime: 2020/5/19
 */
public class JsonData implements Serializable {

    private static final long serialVersionUID = -2746775349913737838L;
    private boolean success;
    private String msg;
    private Object obj;
    private Object otherObj;

    public JsonData() {
    }

    public JsonData(boolean success, String msg, Object obj, Object otherObj) {
        this.success = success;
        this.msg = msg;
        this.obj = obj;
        this.otherObj = otherObj;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setOtherObj(Object otherObj) {
        this.otherObj = otherObj;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    public Object getObj() {
        return obj;
    }

    public Object getOtherObj() {
        return otherObj;
    }

    public JsonData bind(boolean success,String msg){
        setSuccess(success);
        setMsg(msg);
        return this;
    }

    public JsonData bind(boolean success,String msg,Object obj){
        setSuccess(success);
        setMsg(msg);
        setObj(obj);
        return this;
    }

    public JsonData bind(boolean success,String msg,Object obj,Object otherObj){
        setSuccess(success);
        setMsg(msg);
        setObj(obj);
        setOtherObj(otherObj);
        return this;
    }
}