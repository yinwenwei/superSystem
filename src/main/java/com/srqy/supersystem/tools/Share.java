package com.srqy.supersystem.tools;

import java.util.HashSet;
import java.util.List;

/**
 * @Author: yww
 * @CreateTime: 2020/5/18
 */
public class Share {

    public static boolean isEmpty(Object obj){
        if(obj == null){
            return obj == null;
        }else if(obj.getClass().isArray()){
            return obj == null || ((Object[]) obj).length == 0;
        }else if(obj.getClass().getName().contains("HashSet")){
            return obj == null || ((HashSet) obj).size() == 0;
        }else if(obj.getClass().getName().contains("List")){
            return obj == null || ((List) obj).size() == 0;
        }else{
            return (obj.toString() != null ? obj.toString().trim() : "").length() == 0;
        }
    }
}