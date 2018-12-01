package com.zhoujin.chanpin.controller;


import com.zhoujin.commons.entity.User;
import com.zhoujin.chanpin.service.UserServiceApi;
import com.zhoujin.commons.wrapperutil.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

/*    @Autowired
    private RestTemplate restTemplate;*/
    @Value("chanpinkey1")
    private String key1;
    @Value("chanpinkey2")
    private String key2;
    @Value("chanpinkey3")
    private String key3;

    @Autowired
    private UserServiceApi userservice;

    @GetMapping("/chanpin/ribbon")
    public List<User> testRibbon() {
        List<User> list = new ArrayList<>();
        User user = null;
        for (int i = 0; i < 10; i++) {
            //这里使用USER这个服务ID，代表用户维服务系统
            //该ID通过属性spring.application.name来指定
            //user = restTemplate.getForObject("http://USER/user/"+(i+1), UserPo.class);
            Long id = Long.valueOf((i + 1));
            //user = restTemplate.getForObject("http://YONGHU/user/" + (i + 1), User.class);
            Wrapper<User> userWrapper = userservice.getUser(id);
            if(userWrapper.success()) {
                list.add(userWrapper.getResult());
            }
        }
        return list;
    }

    @GetMapping("/chanpin/hello")
    public String sayHello(){
        return  userservice.hello();
    }

    @GetMapping("/chanpin/timeout")
    public Wrapper<String> timeout(){
        return  userservice.timeout();
    }

    @GetMapping("/chanpin/config")
    public String config(){
        return "key1="+key1+"   key2="+key2+"   key3="+key3;
    }
}
