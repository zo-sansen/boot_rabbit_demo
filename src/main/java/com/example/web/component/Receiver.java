package com.example.web.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/3/20.
 * 消费者
 */
@Component
@RabbitListener(queues = Sender.QUEUE_KEY_HELLO)//监听hello队列
public class Receiver {
    @RabbitHandler//指定消息的处理方法
    public void receiver(Object hello){
        String a = "";
        System.out.println("接收到的消息:"+hello);
    }
}
@Component
@RabbitListener(queues = Sender.QUEUE_KEY_DICTOR)
class dictoryListen{

    public void receiver(Object msg){
        System.out.println("dictor listener message："+msg.toString());
    }
}
