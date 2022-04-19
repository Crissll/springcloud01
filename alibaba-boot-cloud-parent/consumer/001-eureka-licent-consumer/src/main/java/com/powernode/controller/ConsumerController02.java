package com.powernode.controller;

import com.powernode.springloud.consts.Url;
import com.powernode.springloud.entity.R;
import com.powernode.springloud.utils.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("lb")
public class ConsumerController02 {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("01")
    public ResponseEntity<R> consumer01(){

        ResponseEntity<R> entity = restTemplate.getForEntity(Url.PROVIDER_01_LOAD_BALANCED, R.class);
        log.info("Body : {}",entity.getBody());
        log.info("Headers : {}",entity.getHeaders());
        log.info("StatusCode : {}",entity.getStatusCode());
        log.info("StatusCodeValue : {}",entity.getStatusCodeValue());
        entity.getBody().put("consumer", 8001);
        return entity;
    }

    @GetMapping("02")
    public R consumer02(){
        HashMap<String, Object> map = new HashMap();
        map.put("id", UUID.getUUID());
        map.put("username", "张删");
        R r = restTemplate.getForObject(Url.PROVIDER_02_LOAD_BALANCED, R.class, map);

        r.put("consumer", 8001);
        return r;
    }

    @GetMapping("03/{username}")
    public R consumer03(@PathVariable String username){
        System.out.println(username);
        HashMap map = new HashMap();
        map.put("id", UUID.getUUID());
        map.put("username", username);
        R r = restTemplate.getForObject(Url.PROVIDER_03_LOAD_BALANCED, R.class, map);
        return r;
    }

    @GetMapping("04")
    public R consumer04(){
        HashMap requestBody = new HashMap();
        requestBody.put("username", "王五");
        requestBody.put("password", 123456);

        HashMap ruiValu = new HashMap();
        ruiValu.put("id", UUID.getUUID());
        ruiValu.put("username", "赵六");
        R r = restTemplate.postForObject(Url.PROVIDER_04_LOAD_BALANCED, requestBody, R.class, ruiValu);
        r.put("consumer", 8001);
        return r;
    }

    @GetMapping("05")
    public R consumer05(){
        HashMap requestBody = new HashMap();
        requestBody.put("username", "刘备");
        requestBody.put("password", 123456);

        HashMap ruialu = new HashMap();
        ruialu.put("id", UUID.getUUID());
        ruialu.put("username", "张飞");
        R r = restTemplate.postForObject(Url.PROVIDER_05_LOAD_BALANCED, requestBody, R.class, ruialu);
        return r;
    }

    @GetMapping("06")
    public R consumer06(){
        HashMap requestBody = new HashMap();
        requestBody.put("username", "刘备");
        requestBody.put("password", 123456);

        HashMap ruialu = new HashMap();
        ruialu.put("id", UUID.getUUID());
        ruialu.put("username", "张飞");
        restTemplate.put(Url.PROVIDER_06_LOAD_BALANCED, requestBody,ruialu);
        return R.ok();
    }

    @GetMapping("07")
    public R consumer07(){
        HashMap ruialu = new HashMap();
        ruialu.put("id", UUID.getUUID());
        ruialu.put("username", "关羽");
        restTemplate.delete(Url.PROVIDER_07_LOAD_BALANCED,ruialu);
        return R.ok();
    }
}
