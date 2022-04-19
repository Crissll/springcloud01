package com.powernode.controller;
import com.powernode.springloud.entity.R;
import com.powernode.springloud.enu.State;
import com.powernode.springloud.utils.DateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("provider")
public class ProvideController {

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("01")
    public R provider01(){
        HashMap map = new HashMap();
        map.put("port", port);
        return R.ok(State.SUCCESS.getCode(),State.SUCCESS.getMsg(),true,map);
    }


    @GetMapping("02/{id}/{username}")
    public R provider02(@PathVariable String id,@PathVariable String username){
        HashMap map = new HashMap();
        map.put("id",id);
        map.put("username", username);
        map.put("date", DateTime.getDateTime());
        map.put("port", port);
        R r = R.ok(State.SUCCESS.getCode(),State.SUCCESS.getMsg(),true,map);
        return r;
    }

    @GetMapping("03/{id}/{username}")
    public R provider03(@PathVariable String id,@PathVariable String username){
        HashMap map = new HashMap();
        map.put("id", id);
        map.put("username", username);
        map.put("port", port);
        return R.ok(State.SUCCESS.getCode(),State.SUCCESS.getMsg(),true,map);
    }

    @PostMapping("04/{id}/{username}")
    public R provider04(@PathVariable String id, @PathVariable String username, @RequestBody String map){
        HashMap data = new HashMap();
        data.put("id", id);
        data.put("username", username);
        data.put("dateTime", DateTime.getDateTime());
        data.put("requestBody", map);
        data.put("port", port);

        return R.ok(State.SUCCESS.getCode(),State.SUCCESS.getMsg(),true,data);
    }

    @PostMapping("05/{id}/{username}")
    public R provider05(@PathVariable String id, @PathVariable String username, @RequestBody Map map, @RequestParam String state,@RequestParam String power){
        HashMap data = new HashMap();
        data.put("id", id);
        data.put("username", username);
        data.put("dateTime", DateTime.getDateTime());
        data.put("requestBody", map);
        data.put("state", state);
        data.put("power", power);
        data.put("port", port);

        return R.ok(State.SUCCESS.getCode(),State.SUCCESS.getMsg(),true,data);
    }


    @PutMapping("06/{id}/{username}")
    public void provide06(@PathVariable String id,@PathVariable String username,@RequestParam String state,@RequestParam String power,@RequestBody Map map){
            log.info("id:{}",id);
            log.info("username:{}",username);
            log.info("state:{}",state);
            log.info("power:{}",power);
            log.info("username1:{}",map);

    }

    //Feign
    @PutMapping("06_Feign/{id}/{username}")
    public R provide06_Feign(@PathVariable String id,@PathVariable String username,@RequestParam String state,@RequestParam String power,@RequestBody Map map){
        log.info("id:{}",id);
        log.info("username:{}",username);
        log.info("state:{}",state);
        log.info("power:{}",power);
        log.info("username1:{}",map);
        HashMap date = new HashMap();
        date.put("id", id);
        date.put("username", username);
        date.put("state", state);
        date.put("power", power);
        date.put("requestBody", map);
        return R.ok(State.SUCCESS.getCode(),State.SUCCESS.getMsg(),true,date);
    }

    @DeleteMapping("07/{id}/{username}")
    public void provide07(@PathVariable String id,@PathVariable String username,@RequestParam String state,@RequestParam String power){
        log.info("id:{}", id);
        log.info("username:{}", username);
        log.info("state:{}", state);
        log.info("power:{}", power);
    }
    @DeleteMapping("07_Feign/{id}/{username}")
    public R provide07_Feign(@PathVariable String id,@PathVariable String username,@RequestParam String state,@RequestParam String power){
        log.info("id:{}", id);
        log.info("username:{}", username);
        log.info("state:{}", state);
        log.info("power:{}", power);
        HashMap date = new HashMap();
        date.put("id",id);
        date.put("username",username);
        date.put("state",state);
        date.put("power",power);
        return R.ok(State.SUCCESS.getCode(),State.SUCCESS.getMsg(),true,date);
    }
}
