package com.example.web.component;

import com.example.config.StaticVar;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 2018/3/22.
 */
@Component
public class SenderThere {
@Autowired
    AmqpTemplate amqpTemplate;

    public void sendFanoutExchange(String routeKey){
       String context = "hello topicExchange："+Sender.sdf.format(new Date())+"\t选择的key："+routeKey;
        amqpTemplate.convertAndSend(StaticVar.TOPIC_EXCHANGE_KEY,routeKey,context);
    }
}
