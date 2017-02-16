package producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by sce on 15.02.2017.
 */
@Component
public class JmsQueueProducer {
    @Autowired
    @Qualifier("jmsQueueTemplate")
    JmsTemplate jmsQueueTemplate;

    @Value("${jms.queue.destination}")
    String destinationQueue;

    public void send(String msg){


        jmsQueueTemplate.convertAndSend(destinationQueue, msg);
    }
}
