package ch.sebooom.pocjms.infrastructure.jms.topics.integration.tests;

import ch.sebooom.pocjms.infrastructure.jms.queue.JmsProducerQueueClient;
import ch.sebooom.pocjms.infrastructure.jms.queue.QueueDestroyer;
import ch.sebooom.pocjms.infrastructure.jms.queue.consumer.sync.JmsReceiveClientExample;
import ch.sebooom.pocjms.infrastructure.jms.topics.JmsProducerTopicsClient;
import org.junit.Before;
import org.junit.Test;

import javax.jms.TextMessage;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by sce on 15.02.2017.
 */
public class JmsSimpleTopicsTest {
    private final static String TOPIC_NAME = "testTopic";
    private final static int NBRE_OF_MESSAGES = 20;

    @Before
    public void initQueue() throws Exception {
        //destroy
        //QueueDestroyer.destroyQueue(QUEUE_NAME);

        //put 20 messages
        JmsProducerTopicsClient.sendMessagesToTopic(TOPIC_NAME,NBRE_OF_MESSAGES);
    }

    @Test
    public void testIfConsummerGetExactNumberOfMessages() throws Exception {

        //List<TextMessage> messagesConsummed = JmsReceiveClientExample.pollMessages(QUEUE_NAME);

        //assertTrue("Number of messages:" + messagesConsummed.size(),messagesConsummed.size() == NBRE_OF_MESSAGES + 1);

    }

}
