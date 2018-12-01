package com.zhoujin.chanpin.service;

import com.zhoujin.chanpin.service.impl.UserServiceApiHystrix;
import com.zhoujin.commons.entity.User;
import com.zhoujin.commons.wrapperutil.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "yonghu",fallback = UserServiceApiHystrix.class)
public interface UserServiceApi {

    @GetMapping("/user/{id}")
    public Wrapper<User> getUser(@PathVariable("id") Long id);

    @GetMapping("/user/hello")
    public String hello();

    @GetMapping("/user/timeout")
    public Wrapper<String> timeout();
}
