package ch.sebooom.pocjms.infrastructure.jms.queue;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.net.URISyntaxException;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class JmsProducerQueueClient {

    public static void sendMessagesToQueue(String queueName, int nbreOfMessage) throws URISyntaxException, Exception {
        Connection connection = null;

        try {
            // Producer
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                    ActiveMQConnection.DEFAULT_BROKER_URL);

            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(queueName);

            MessageProducer producer = session.createProducer(queue);
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
