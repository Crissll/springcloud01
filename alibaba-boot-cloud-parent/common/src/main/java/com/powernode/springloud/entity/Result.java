package com.powernode.springloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private boolean success;
    private T date;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T date) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }

    public static Result ok(){
        return new Result(20000,"操作成功",true,null);
    }

    public static Result ok(Integer code,String msg){
        return new Result(code,msg,true,null);
    }

    public static <T      >Result ok(Integer code,String msg,T date){
        return new Result(code,msg,true,date);
    }
}
