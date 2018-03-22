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
public class SenderTwo {
@Autowired
    AmqpTemplate amqpTemplate;

    public void sendFanoutExchange(){
       String context = "hello fanoutExchange"+Sender.sdf.format(new Date());
        amqpTemplate.convertAndSend(StaticVar.FANOUT_EXCHANGE_KEY_ONE,"",context);
    }
}
