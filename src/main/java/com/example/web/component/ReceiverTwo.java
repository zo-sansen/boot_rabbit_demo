package com.example.web.component;

import com.example.config.StaticVar;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/3/22.
 * 监控fanout exchange绑定的队列
 */
@Component
@RabbitListener(queues = StaticVar.FANOUT_QUEUE_ONE)//
public class ReceiverTwo {
    @RabbitHandler
    public void receiver(String msg){
        System.out.println("fanout exchange one receiver message:"+msg);
    }
}
@Component
@RabbitListener(queues = StaticVar.FANOUT_QUEUE_TWO)//
class ReceiverTwo2 {
    @RabbitHandler
    public void receiver(String msg){
        System.out.println("fanout exchange two receiver message:"+msg);
    }
}