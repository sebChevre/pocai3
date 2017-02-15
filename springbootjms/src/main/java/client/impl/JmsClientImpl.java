package client.impl;

import client.JmsClient;
import consumer.JmsConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import producer.JmsProducer;

/**
 * Created by sce on 15.02.2017.
 */
@Component
public class JmsClientImpl implements JmsClient {

    @Autowired
    JmsConsumer jmsConsumer;

    @Autowired
    JmsProducer jmsProducer;

    @Override
    public void send(String msg) {
        jmsProducer.send(msg);
    }

    @Override
    public String receive() {
        return jmsConsumer.receive();
    }
}
