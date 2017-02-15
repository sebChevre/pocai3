package consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by sce on 15.02.2017.
 */
@Component
public class JmsQueueConsumer {
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${jms.queue.destination}")
    String destinationQueue;

    public String receive(){

        return (String)jmsTemplate.receiveAndConvert(destinationQueue);
    }
}
