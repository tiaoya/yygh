package com.zhong.yygh.common.result;


import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zhong
 * @Description :
 * @create : 2022/10/22-21:19
 */
@Getter
@ToString
public class R {

    private Integer code;
    private String message;
    private Boolean success;
    private Map<String,Object> data = new HashMap<>();

    // 为了不让外部创建这个 R 对象
    private R(){

    }

    // 返回 R 可以方便链式调用
    public static R ok(){
        R r = new R();
        r.code = REnum.SUCCESS.getCode();
        r.success = REnum.SUCCESS.getFlag();
        r.message = REnum.SUCCESS.getMessage();
        return r;
    }

    public static R error(){
        R r = new R();
        r.code = REnum.ERROR.getCode();
        r.success = REnum.ERROR.getFlag();
        r.message = REnum.ERROR.getMessage();
        return r;
    }

    public R code(Integer code){
        this.code = code;
        return this;
    }
    public R message(String message){
        this.message = message;
        return this;
    }
    public R success(Boolean success){
        this.success = success;
        return this;
    }
    public R data(String key,Object value){
        this.data.put(key,value);
        return this;
    }
    public R data(Map<String,Object> map){
        this.data= map;
        return this;
    }



}
