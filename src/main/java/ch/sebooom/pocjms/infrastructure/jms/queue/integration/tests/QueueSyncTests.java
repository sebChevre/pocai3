package ch.sebooom.pocjms.infrastructure.jms.queue.integration.tests;

import ch.sebooom.pocjms.infrastructure.jms.queue.JmsProducerQueueClient;
import ch.sebooom.pocjms.infrastructure.jms.queue.QueueDestroyer;
import ch.sebooom.pocjms.infrastructure.jms.queue.consumer.sync.JmsReceiveClientExample;
import org.junit.Before;
import org.junit.Test;

import javax.jms.TextMessage;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class QueueSyncTests {

    private final static String QUEUE_NAME = "testQueue";
    private final static int NBRE_OF_MESSAGES = 20;

    @Before
    public void initQueue() throws Exception {
        //destroy
        QueueDestroyer.destroyQueue(QUEUE_NAME);

        //put 20 messages
        JmsProducerQueueClient.sendMessagesToQueue(QUEUE_NAME,NBRE_OF_MESSAGES);
    }

    @Test
    public void testIfConsummerGetExactNumberOfMessages() throws Exception {

        List<TextMessage> messagesConsummed = JmsReceiveClientExample.pollMessages(QUEUE_NAME);

        assertTrue("Number of messages:" + messagesConsummed.size(),messagesConsummed.size() == NBRE_OF_MESSAGES + 1);

    }


}
