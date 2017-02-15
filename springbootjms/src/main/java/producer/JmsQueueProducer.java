package producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by sce on 15.02.2017.
 */
@Component
public class JmsQueueProducer {
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${jms.queue.destination}")
    String destinationQueue;

    public void send(String msg){


        jmsTemplate.convertAndSend(destinationQueue, msg);
    }
}
