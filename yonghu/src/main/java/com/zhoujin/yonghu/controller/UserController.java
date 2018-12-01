package com.zhoujin.yonghu.controller;

import com.zhoujin.commons.entity.User;
import com.zhoujin.chanpin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserService{
    //日志
    private static final Logger log= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    //获取用户信息
    public User getUser(@PathVariable("id") Long id){
        ServiceInstance service = discoveryClient.getInstances("yonghu").get(0);
        log.info("【"+service.getServiceId()+"】"+service.getHost()+": "+service.getPort());
        User userPo=new User();
        userPo.setId(id);
        userPo.setLevel((int) (id&3+1));
        userPo.setUserName("user_name_"+id);
        userPo.setNote("note_"+id);
        return userPo;
    }

    @Override
    public String hello() {
        return "hello";
    }

    @Override
    public String timeout() {
        //生辰一个3000之内的随机数
        long ms=(long)(5000L*Math.random());
        try{
            //程序延迟。有一定的概率超过2000ms
            Thread.sleep(ms);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "正常返回，熔断失败";
    }
}



