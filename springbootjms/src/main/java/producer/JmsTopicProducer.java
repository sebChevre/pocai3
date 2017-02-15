package producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
@Component
public class JmsTopicProducer {
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${jms.topic.destination}")
    String destinationTopic;

    public void send(String msg){
        jmsTemplate.setPubSubDomain(Boolean.TRUE);
        jmsTemplate.convertAndSend(destinationTopic, msg);
    }
}
