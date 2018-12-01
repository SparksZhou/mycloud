package com.zhoujin.yonghu.controller;

import com.zhoujin.commons.entity.User;
import com.zhoujin.chanpin.service.UserServiceApi;
import com.zhoujin.commons.wrapperutil.WrapMapper;
import com.zhoujin.commons.wrapperutil.Wrapper;
import com.zhoujin.yonghu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerApi implements UserServiceApi {
    //日志
    private static final Logger log= LoggerFactory.getLogger(UserControllerApi.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserService userService;

    //获取用户信息
    public Wrapper<User> getUser(@PathVariable("id") Long id){
        ServiceInstance service = discoveryClient.getInstances("yonghu").get(0);
        log.info("【"+service.getServiceId()+"】"+service.getHost()+": "+service.getPort());
        User user = userService.getUserById(id);
        return WrapMapper.ok(user);
    }

    @Override
    public String hello() {
        return "hello";
    }

    @Override
    public Wrapper<String> timeout() {
        //生辰一个3000之内的随机数
        long ms=(long)(5000L*Math.random());
        try{
            //程序延迟。有一定的概率超过2000ms
            Thread.sleep(ms);
        }catch(Exception e){
            e.printStackTrace();
        }
        return WrapMapper.ok("正常返回，熔断失败");
    }
}



