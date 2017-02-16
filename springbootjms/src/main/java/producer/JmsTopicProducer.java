package producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("jmsTopicTemplate")
    JmsTemplate jmsTopicTemplate;

    @Value("${jms.topic.destination}")
    String destinationTopic;

    public void send(String msg){
        jmsTopicTemplate.setPubSubDomain(Boolean.TRUE);
        jmsTopicTemplate.convertAndSend(destinationTopic, msg);
    }
}
