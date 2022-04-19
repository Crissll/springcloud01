package com.powernode.springloud.entity;

import com.powernode.springloud.enu.State;

import java.util.HashMap;

public class R extends HashMap {
    public static R ok(){
        R r = new R();
        r.put("code", State.SUCCESS.getCode());
        r.put("msg", State.SUCCESS.getMsg());
        r.put("success", true);
        r.put("date", null);
        return r;
    }

    public static R ok(Integer code,String msg){
        R r = new R();
        r.put("code", State.SUCCESS.getCode());
        r.put("msg", State.SUCCESS.getMsg());
        r.put("success", true);
        r.put("date", null);
        return r;
    }

    public static R ok(Integer code,String msg,boolean success){
        R r = new R();
        r.put("code", State.SUCCESS.getCode());
        r.put("msg", State.SUCCESS.getMsg());
        r.put("success", success);
        r.put("date", null);
        return r;
    }

    public static <T>R ok(Integer code,String msg,boolean success,T date){
        R r = new R();
        r.put("code", State.SUCCESS.getCode());
        r.put("msg", State.SUCCESS.getMsg());
        r.put("success", success);
        r.put("date", date);
        return r;
    }

    public static R error(){
        R r = new R();
        r.put("code", State.FALL.getCode());
        r.put("msg", State.FALL.getMsg());
        r.put("success", false);
        r.put("date", null);
        return r;
    }
}
