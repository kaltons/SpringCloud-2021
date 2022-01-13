package com.fanghua.springcloud.service.impl;

import com.fanghua.springcloud.service.IMessageProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 发送消息接口实现类
 *
 * EnableBinding 定义消息的推送管道
 * @author fcwei
 * @date 2021/11/20 - 16:42
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    private static final Log log = LogFactory.getLog(MessageProviderImpl.class);

    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("serial: {}" + serial);
        return null;
    }
}
