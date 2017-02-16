package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.logging.Logger;

/**
 * Created by sce on 16.02.2017.
 */

@ComponentScan

public class Application {

    private static final Logger logger = Logger.getLogger(Application.class.getName());

    @Value("${jms.topic.destination}")
    String destinationTopic;

    @Autowired
    private TopicProducer topicP;

    public static void main(String[] args) {

        logger.info("Application starting... - "  + Thread.currentThread().getName());

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class);

        logger.info("Application started done! - " + Thread.currentThread().getName());

        TopicProducer asyncProducer = context.getBean(TopicProducer.class);
        asyncProducer.sendMessages();


    }
}
