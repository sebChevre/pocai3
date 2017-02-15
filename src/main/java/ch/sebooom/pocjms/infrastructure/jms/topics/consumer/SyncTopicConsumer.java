package ch.sebooom.pocjms.infrastructure.jms.topics.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sce on 15.02.2017.
 */
public class SyncTopicConsumer {

    public static List pollMessages(String queueName) throws URISyntaxException, Exception {

        Connection connection = null;
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "tcp://localhost:61616");
        connection = connectionFactory.createConnection();
        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);

        List<TextMessage> messagresConsumed;

        try {
            Topic topic = session.createTopic(queueName);

            // Consumer
            MessageConsumer consumer = session.createConsumer(topic);
            connection.start();

            //store messages for tests
            messagresConsumed = new ArrayList<TextMessage>();

            while (true) {
                TextMessage textMsg = (TextMessage) consumer.receive();
                System.out.println(textMsg);
                System.out.println("Received: " + textMsg.getText());
                messagresConsumed.add(textMsg);
                if (textMsg.getText().equals("END")) {
                    break;
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return messagresConsumed;
    }
}
