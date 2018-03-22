package com.example.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/3/22.
 */
@Configuration
public class RabbitConfigTwo {
    @Bean
    public Queue initQueueOne(){
        return new Queue(StaticVar.FANOUT_QUEUE_ONE);
    }
    @Bean
    public Queue initQueueTwo(){
        return new Queue(StaticVar.FANOUT_QUEUE_TWO);
    }
    @Bean
    public Exchange fanoutExchange(){
        return new FanoutExchange(StaticVar.FANOUT_EXCHANGE_KEY_ONE);
    }
    @Bean
    public Binding queueBindingExchangeOne(Queue initQueueOne,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(initQueueOne).to(fanoutExchange);
    }

    @Bean
    public Binding queueBindingExchangeTwo(Queue initQueueTwo,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(initQueueTwo).to(fanoutExchange);
    }
}
