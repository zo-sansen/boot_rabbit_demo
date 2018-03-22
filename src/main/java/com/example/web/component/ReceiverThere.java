package com.example.web.component;

import com.example.config.StaticVar;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/3/22.
 */
@Configuration
@RabbitListener(queues = StaticVar.TOPIC_QUEUE_ONE)
public class ReceiverThere {

    @RabbitHandler
    public void receive(String msg){
        System.out.println(StaticVar.TOPIC_QUEUE_ONE+">one>"+"receive message："+msg);
    }
}
@Configuration
@RabbitListener(queues = StaticVar.TOPIC_QUEUE_TWO)
 class ReceiverThere2 {

    @RabbitHandler
    public void receive(String msg){
        System.out.println(StaticVar.TOPIC_QUEUE_TWO+">two>"+"receive message："+msg);
    }
}
@Configuration
@RabbitListener(queues = StaticVar.TOPIC_QUEUE_THERE)
 class ReceiverThere3 {

    @RabbitHandler
    public void receive(String msg){
        System.out.println(StaticVar.TOPIC_QUEUE_THERE+">there>"+"receive message："+msg);
    }
}
