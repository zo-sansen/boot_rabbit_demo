package com.example.web.controller;

import com.example.config.StaticVar;
import com.example.web.component.Sender;
import com.example.web.component.SenderThere;
import com.example.web.component.SenderTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/3/20.
 *
 * 默认交换机模式
 *
 */
@RestController
public class HelloController {

    @Autowired
    Sender sender;
    @Autowired
    SenderTwo senderTwo;
    @Autowired
    SenderThere senderThere;

    @RequestMapping("/hi")
    public void hello(){
        sender.send();
    }
    @RequestMapping("/dictor")
    public void dictor(){
        sender.dictorSend();
    }
@RequestMapping("/sendFanoutExchange")
    public void sendFanoutExchange(){
        senderTwo.sendFanoutExchange();
    }
    @RequestMapping("/topicOne")
    public void topicOne(){
        senderThere.sendFanoutExchange(StaticVar.TOPIC_QUEUE_ONE);
    }
    @RequestMapping("/topicTwo")
    public void topicTwo(){
        senderThere.sendFanoutExchange("topic");
    }

    @RequestMapping("/topic3")
    public void topic3(){
        senderThere.sendFanoutExchange("topic.*");
    }

    @RequestMapping("/topic4")
    public void topic4(){
        senderThere.sendFanoutExchange("topic.my*");
    }

    @RequestMapping("/topic5")
    public void topic5(){
        senderThere.sendFanoutExchange("topic.#");
    }
}
