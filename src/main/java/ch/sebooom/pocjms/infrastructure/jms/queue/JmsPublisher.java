package ch.sebooom.pocjms.infrastructure.jms.queue;

import ch.sebooom.pocjms.domain.message.Publisher;

import javax.jms.*;
import java.util.logging.Logger;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class JmsPublisher<T> implements Publisher<T>,ExceptionListener{

    private static final Logger logger = Logger.getLogger(JmsPublisher.class.getName());
    private Connection connection = null;

    public static JmsPublisher get(ConnectionFactory c) {

        try {

            JmsPublisher p = new JmsPublisher();
            p.connection = c.createConnection();
            p.connection.start();
            p.connection.setExceptionListener(p);

            // session
            Session session = p.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // destination
            Destination destination = session.createQueue("TEST.FOO-1");

            // Create a MessageProducer from the Session to the Topic or Queue
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);




        } catch (JMSException e) {
            logger.info(e.getMessage());
        }
        return null;
    }

    public void publish(T message) {

        // Create a messages
        String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
      //  TextMessage message = session.createTextMessage(text);

        // Tell the producer to send the message
        logger.info("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
        //producer.send(message);

        // Clean up
        //session.close();
        //connection.close();
    }

    public void onException(JMSException e) {

    }
}
