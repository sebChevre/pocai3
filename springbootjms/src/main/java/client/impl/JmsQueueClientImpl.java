package client.impl;

import client.JmsQueueClient;
import consumer.JmsQueueConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import producer.JmsQueueProducer;

/**
 * Created by sce on 15.02.2017.
 */
@Component
public class JmsQueueClientImpl implements JmsQueueClient {

    @Autowired
    JmsQueueConsumer jmsQueueConsumer;

    @Autowired
    JmsQueueProducer jmsProducer;

    @Override
    public void send(String msg) {
        jmsProducer.send(msg);
    }

    @Override
    public String receive() {
        return jmsQueueConsumer.receive();
    }
}
