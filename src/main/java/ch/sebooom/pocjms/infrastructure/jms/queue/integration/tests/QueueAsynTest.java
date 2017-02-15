package ch.sebooom.pocjms.infrastructure.jms.queue.integration.tests;

import ch.sebooom.pocjms.infrastructure.jms.queue.JmsProducerQueueClient;
import ch.sebooom.pocjms.infrastructure.jms.queue.QueueDestroyer;
import ch.sebooom.pocjms.infrastructure.jms.queue.consumer.async.JmsAsyncReceiveQueueClientExample;
import ch.sebooom.pocjms.infrastructure.jms.queue.consumer.async.RxBus;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class QueueAsynTest {

    private final static String QUEUE_NAME = "testAsyncQueue";
    private final static int NBRE_OF_MESSAGES = 15;

    @Before
    public void initQueue() throws Exception {
        //destroy
        QueueDestroyer.destroyQueue(QUEUE_NAME);

        //put 20 messages
        JmsProducerQueueClient.sendMessagesToQueue(QUEUE_NAME,NBRE_OF_MESSAGES);
    }

    @Test
    public void testIfConsummerGetExactNumberOfMessages() throws Exception {

       RxBus.get().toObservable().count().subscribe(next -> {
           assertTrue("Number of messages:" +next,next == NBRE_OF_MESSAGES + 1);
        });

        JmsAsyncReceiveQueueClientExample asyncReceiveClient = new JmsAsyncReceiveQueueClientExample();
        asyncReceiveClient.receiveMessages();


    }
}
