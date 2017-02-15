package consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import java.util.logging.Logger;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
@Component
public class JmsTopicConsumer  {

    static final Logger LOG = Logger.getLogger(JmsTopicConsumer.class.getName());


    @JmsListener(destination = "DEMO-JMS-TOPIC")
    public void onMessage(Message message) {
        //jmsTemplate.setPubSubDomain(Boolean.TRUE);
        System.out.println("ok topic:" + message);
    }
}
