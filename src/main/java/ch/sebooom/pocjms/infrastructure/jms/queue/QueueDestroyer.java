package ch.sebooom.pocjms.infrastructure.jms.queue;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import java.util.logging.Logger;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class QueueDestroyer {

    private final static Logger logger = Logger.getLogger(QueueDestroyer.class.getName());

    public static void destroyQueue(String queueName) {

        ActiveMQConnection connection = null;

        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                    ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = (ActiveMQConnection) connectionFactory.createConnection();


            connection.destroyDestination(new ActiveMQQueue(queueName));

        }catch(JMSException e){

            logger.severe(e.getMessage());

        }finally{
            try {
                connection.close();
            } catch (JMSException e) {
                logger.severe("Cant close connection:" + e.getMessage());
            }
        }

    }


}
