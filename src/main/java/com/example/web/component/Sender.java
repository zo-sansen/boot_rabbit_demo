package com.example.web.component;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/20.
 * 生产者
 */
@Component
public class Sender {

    public static final String QUEUE_KEY_HELLO = "hello";
    public static final String QUEUE_KEY_DICTOR = "dictor";

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello" + sdf.format(new Date());
        System.out.println("生产一条信息：" + context);
        rabbitTemplate.convertAndSend(QUEUE_KEY_HELLO, context);
        Message message = new Message((context + " send method").getBytes(), new MessageProperties());
        rabbitTemplate.send(QUEUE_KEY_HELLO, message);

        Message receive = rabbitTemplate.receive(QUEUE_KEY_HELLO);
        System.out.println("自发自接"+receive);
    }

    public void dictorSend() {
        String context = "dictor hello" + sdf.format(new Date());
        System.out.println("生产了一条dictor queue message");
        MessageProperties props = MessagePropertiesBuilder.newInstance().build();
        Message message = MessageBuilder.withBody(context.getBytes()).build();
        rabbitTemplate.send(QUEUE_KEY_DICTOR,message);
    }
}
