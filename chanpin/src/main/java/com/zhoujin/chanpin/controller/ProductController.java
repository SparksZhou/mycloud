package com.zhoujin.chanpin.controller;


import com.zhoujin.commons.entity.User;
import com.zhoujin.chanpin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

/*    @Autowired
    private RestTemplate restTemplate;*/

    @Autowired
    private UserService userservice;

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
            user=userservice.getUser(id);
            list.add(user);
        }
        return list;
    }

    @GetMapping("/chanpin/hello")
    public String sayHello(){
        return  userservice.hello();
    }

    @GetMapping("/chanpin/timeout")
    public String timeout(){
        return  userservice.timeout();
    }
}
