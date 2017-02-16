package config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import java.util.Arrays;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
@Configuration
public class MessagingConfiguration {

    public static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
    public static final String ORDER_TOPIC = "DEMO-JMS-TOPIC";
    public static final String ORDER_QUEUE = "DEMO-JMS-QUEUE";


    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        //connectionFactory.setTrustedPackages(Arrays.asList("com.websystique.spring","java.util"));
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTopicTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setPubSubDomain(Boolean.TRUE);
        template.setDefaultDestinationName(ORDER_TOPIC);
        return template;
    }

    @Bean
    public JmsTemplate jmsQueueTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        //template.setPubSubDomain(Boolean.TRUE);
        template.setDefaultDestinationName(ORDER_QUEUE);
        return template;
    }
}
