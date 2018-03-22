package com.example.config;

/**
 * Created by Administrator on 2018/3/22.
 */
public class StaticVar {
    public static final String a = "";

    /**
     * fanout exchange 扇出模式测试routeKey
     */
    public static final String FANOUT_QUEUE_ONE = "fanout.queue.one";
    public static final String FANOUT_QUEUE_TWO = "fanout.queue.two";
    /**
     * fanout exchange key
     */
    public static final String FANOUT_EXCHANGE_KEY_ONE = "fanoutExchange";

    public static final String TOPIC_EXCHANGE_KEY = "topicExchange";
    public static final String TOPIC_QUEUE_ONE = "topic.msg";
    public static final String TOPIC_QUEUE_TWO = "topic.msg.y";
    public static final String TOPIC_QUEUE_THERE = "topic.myl";

}
