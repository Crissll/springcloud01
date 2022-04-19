package com.pwernode.server;

import com.powernode.springloud.consts.Url;
import com.powernode.springloud.entity.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Feign实现步骤
 *      1.创建一个接口，ProviderServer
 *      2.接口上修饰一个注解，@FeignClient(name=“远程调用的微服务名称”)
 *      3.在接口中定义方法(不能狗又方法体)，该方法即是远程调用发送请求的方法
 *      4.在方法上添加不用的注解代表不同的请求方式
 *          get:@GetMapping
 *          post:@PostMapping
 *          put:@PutMapping
 *          delete:@DeleteMapping
 *      5.在方法定义时，远程调用的目的地的方法和Feign中接口定义的方法的返回值和参数列表一至
 *          Provider: R provider01(id,username)
 *          Feign:  R abc("方法名可以不一样")(id,username)
 *
 *      6.传递参数时，我们有多种参数封装的方式
 *          无参请求
 *          有参请求
 *              将参数封装到地址栏中的键值对中
 *                  参数上添加@RequestParam(name="")注解
 *              将参数封装到地址栏中的（RestFul风格）
 *                  参数上添加@PathVariable(name="")注解
 *              将参数封装到请求体中（或者传递json数据）
 *                  参数上添加@RequestBody(name="")注解
 */
@FeignClient(name = Url.EUREKA_CLIENT_PROVIDER)
public interface ProvideServer {

    /**
     * 在控制器中调用当前方法，即可实现远程调用
     *      在接口上声明了一个注解，注解中有一个属性，代表访问的微服务
     *          http://localhost:7001 http://localhost:7002
     *      在接口的方法上，声明了控制器的地址及参数和请求方式
     *          http://localhost:7001/provider/01
     *          http://localhost:7001/provider/01
     * @return
     */
    @GetMapping(Url.Feign_PROVIDER_01)
    R provider01();

    @GetMapping(Url.Feign_PROVIDER_02)
    R provider02(@PathVariable(name="id") String id, @PathVariable(name = "username") String username);

    @GetMapping(Url.Feign_PROVIDER_03)
    R provider03(@PathVariable(name = "id") String id, @PathVariable(name = "username") String username);

    /*@PostMapping(Url.Feign_PROVIDER_04)
    R provider04(@PathVariable(name="id") String id,
                 @PathVariable(name = "username") String username,
                 @RequestBody Map<String , Object> requestBody
                 );*/
    @PostMapping(Url.Feign_PROVIDER_04)
    R provider04(@PathVariable(name="id") String id,
                 @PathVariable(name = "username") String username,
                 @RequestBody String requestBody
    );

    @PostMapping(Url.Feign_PROVIDER_05)
    R provider05(
            @PathVariable(name="id") String id,
            @PathVariable(name = "username") String username,
            @RequestBody Map<String , Object> requestBody
    );

    @PutMapping(Url.Feign_PROVIDER_06)
    R provider06(
            @PathVariable(name="id") String id,
            @PathVariable(name = "username") String username,
            @RequestBody Map<String , Object> requestBody
    );

    @DeleteMapping(Url.Feign_PROVIDER_07)
    R provider07(
            @PathVariable(name="id") String id,
            @PathVariable(name = "username") String username
    );
}
