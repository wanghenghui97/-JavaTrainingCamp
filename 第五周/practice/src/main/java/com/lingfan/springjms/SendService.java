package com.lingfan.springjms;

import com.alibaba.fastjson.JSON;
import com.lingfan.spring01.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class SendService {
    @Autowired
    JmsTemplate jmsTemplate;

    public void send(final Student student){
        jmsTemplate.send(
                "test.queue", new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createObjectMessage(JSON.toJSONString(student));
                    }
                }
        );
    }
}
