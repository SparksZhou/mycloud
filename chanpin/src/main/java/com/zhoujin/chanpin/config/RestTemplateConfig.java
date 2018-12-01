package com.zhoujin.chanpin.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    //初始化RestTemplate
    @LoadBalanced //多节点负载均衡
    @Bean(name="restTemplate")
    public RestTemplate initRestTemplate(){
        return new RestTemplate();
    }
}
