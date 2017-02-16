package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by sce on 16.02.2017.
 */
@Component
public class TopicProducer {

    private static final Logger logger = Logger.getLogger(TopicProducer.class.getName());

    @Autowired
    @Qualifier("jmsTopicTemplate")
    JmsTemplate jmsTopicTemplate;

    @Value("${jms.topic.destination}")
    String destinationTopic;

    @Async
    public void sendMessages(){

        String msg = "topic msg n° ";

        for(int i = 0; i < 20; i++){
            jmsTopicTemplate.setPubSubDomain(Boolean.TRUE);
            jmsTopicTemplate.convertAndSend(destinationTopic, msg + i);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                logger.severe("Problem during thread sleep: " + e.getMessage());
            }
        }


    }


}
