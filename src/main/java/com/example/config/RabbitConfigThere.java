package com.example.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/3/22.
 */
@Configuration
public class RabbitConfigThere {
    @Bean
    public Queue initQueueOneTopic(){
        return new Queue(StaticVar.TOPIC_QUEUE_ONE);
    }
    @Bean
    public Queue initQueueTwoTopic(){
        return new Queue(StaticVar.TOPIC_QUEUE_TWO);
    }
    @Bean
    public Queue initQueueThereTopic(){
        return new Queue(StaticVar.TOPIC_QUEUE_THERE);
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(StaticVar.TOPIC_EXCHANGE_KEY);
    }

    @Bean
    Binding bindingExchangeMessage(Queue initQueueOneTopic, TopicExchange topicExchange) {
        return BindingBuilder.bind(initQueueOneTopic).to(topicExchange).with("topic.msg");
    }

    @Bean
    Binding bindingExchangeMessages(Queue initQueueTwoTopic, TopicExchange topicExchange) {
        return BindingBuilder.bind(initQueueTwoTopic).to(topicExchange).with("topic.msg.#");
    }

    @Bean
    Binding bindingExchangeYmq(Queue initQueueThereTopic, TopicExchange topicExchange) {
        return BindingBuilder.bind(initQueueThereTopic).to(topicExchange).with("topic.#");
    }


}
