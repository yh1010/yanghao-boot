package com.yanghao.boot.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author yanghao
 * @create 2020-03-16 16:45
 * @Description: Error日志消费者 - 接收者
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "${mq.config.queue.error}",autoDelete = "true"),
        exchange =@Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.TOPIC),
        key = "*.log.error"
))
public class ErrorReceiver {

    @RabbitHandler
    public void receiver(String msg){
        System.out.println("--------error---------日志" + msg);
    }
}
