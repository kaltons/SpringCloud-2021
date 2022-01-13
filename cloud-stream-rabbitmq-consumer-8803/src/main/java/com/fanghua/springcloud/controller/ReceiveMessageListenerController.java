package com.fanghua.springcloud.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 服务消费者
 *
 * @author fcwei
 * @date 2021/11/20 - 17:26
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    private static final Log log = LogFactory.getLog(ReceiveMessageListenerController.class);

    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message)
    {
        log.info("消费者2号,----->接受到的消息: " + message.getPayload()+"\t  port: "+serverPort);
    }
}
