package ch.sebooom.pocjms.infrastructure.jms.topics;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.net.URISyntaxException;

/**
 * Created by sce on 15.02.2017.
 */
public class JmsProducerTopicsClient {
    public static void sendMessagesToTopic(String queueName, int nbreOfMessage) throws URISyntaxException, Exception {
        Connection connection = null;

        try {
            // Producer
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                    ActiveMQConnection.DEFAULT_BROKER_URL);

            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);

            Topic topic = session.createTopic("testTopic");
            //Queue queue = session.createQueue(queueName);

            MessageProducer producer = session.createProducer(topic);
            String task = "Task";

            for (int i = 0; i < nbreOfMessage; i++) {
                String payload = task + i;
                Message msg = session.createTextMessage(payload);
                System.out.println("Sending text '" + payload + "'");
                producer.send(msg);
            }
            producer.send(session.createTextMessage("END"));
            session.close();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
