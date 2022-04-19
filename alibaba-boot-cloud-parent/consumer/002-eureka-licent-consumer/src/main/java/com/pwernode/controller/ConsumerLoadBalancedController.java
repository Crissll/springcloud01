package com.pwernode.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.powernode.springloud.consts.Url;
import com.powernode.springloud.entity.R;
import com.powernode.springloud.utils.UUID;
import com.pwernode.server.ProvideServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("lb")
public class ConsumerLoadBalancedController{

    @Autowired
    private ProvideServer provideServer;

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("01")
    public ResponseEntity<R> consumer01(){

        R r = provideServer.provider01();
        r.put("consumer",port);
        return ResponseEntity.ok(r);
    }

    @GetMapping("02")
    public R consumer02(){
        R r = provideServer.provider02(UUID.getUUID(),"张三");
        r.put("consumer", port);
        return r;
    }

    @GetMapping("03/{user}")
    public R consumer03(@PathVariable String user){
        R r = provideServer.provider03(UUID.getUUID(),"刘备");
        r.put("user", user);
        return r;
    }
//请求体body类型为map
    /*@GetMapping("04")
    public R consumer04(){
        HashMap requestBody = new HashMap();
        requestBody.put("username", "王五");
        requestBody.put("password", 123456);
        R r = provideServer.provider04(UUID.getUUID(), "张飞", requestBody);

        r.put("consumer", port);
        return r;
    }*/

    //请求体body类型为String
    @GetMapping("04")
    public R consumer04() throws JsonProcessingException {
        HashMap requestBody = new HashMap();
        requestBody.put("username", "王五");
        requestBody.put("password", 123456);
        R r = provideServer.provider04(UUID.getUUID(), "张飞",new ObjectMapper().writeValueAsString(requestBody));

        r.put("consumer", port);
        return r;
    }

    @GetMapping("05")
    public R consumer05(){
        HashMap requestBody = new HashMap();
        requestBody.put("username", "刘备");
        requestBody.put("password", 123456);
        R r = provideServer.provider05(UUID.getUUID(), "李世源",requestBody);
        return r;
    }

    @GetMapping("06")
    public R consumer06(){
        HashMap requestBody = new HashMap();
        requestBody.put("username", "刘备");
        requestBody.put("password", 123456);
        R r = provideServer.provider06(UUID.getUUID(), "李星云", requestBody);
        return r;
    }

    @GetMapping("07")
    public R consumer07(){
        R r = provideServer.provider07(UUID.getUUID(), "龙泉");
        return r;
    }
}
