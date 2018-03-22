package com.example.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/3/20.
 * 典型配置方式，默认创建需要的队列
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue helloInit() {
        return new Queue("hello");
    }

    @Bean
    public Queue dictorInit() {
        return new Queue("dictor");
    }
}
