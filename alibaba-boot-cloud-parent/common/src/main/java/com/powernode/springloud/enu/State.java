package com.powernode.springloud.enu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum State{
    SUCCESS(20000,"操作成功"),
    FALL(20001,"操作失败")
    ;

    private Integer code;
    private String msg;
}
