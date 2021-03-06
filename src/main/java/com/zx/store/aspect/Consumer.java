package com.zx.store.aspect;


import com.zx.store.bean.AspectInfo;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    private AspectService aspectService;

    @RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
    public void process( Message message) {
        Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        AspectInfo aspectInfo = (AspectInfo)jackson2JsonMessageConverter.fromMessage(message);
        aspectService.insertAspectInfo(aspectInfo);
    }

//    @RabbitListener(bindings = {
//            @QueueBinding(
//                    value = @Queue,
//                    exchange = @Exchange(value = "TestDirectQueue",type = "direct"),
//                    key = {"TestDirectQueue"}
//            )
//    })
//    public void process1( Message message) {
//        System.out.println("message = " + message);
//    }
}

