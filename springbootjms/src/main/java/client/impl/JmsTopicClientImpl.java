package client.impl;

import client.JmsTopicClient;
import consumer.JmsTopicConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import producer.JmsTopicProducer;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
@Component
public class JmsTopicClientImpl implements JmsTopicClient {

    @Autowired
    JmsTopicConsumer jmsQueueConsumer;

    @Autowired
    JmsTopicProducer jmsProducer;

    @Override
    public void send(String msg) {
        jmsProducer.send(msg);
    }

    @Override
    public String receive() {
        return null;
    }
}
