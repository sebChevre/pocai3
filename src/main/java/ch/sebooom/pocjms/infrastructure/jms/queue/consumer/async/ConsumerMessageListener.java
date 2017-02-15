package ch.sebooom.pocjms.infrastructure.jms.queue.consumer.async;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class ConsumerMessageListener implements MessageListener{
    private String consumerName;
    private JmsAsyncReceiveQueueClientExample asyncReceiveQueueClientExample;
    private RxBus bus;

    public ConsumerMessageListener(String consumerName) {
        this.consumerName = consumerName;
        this.bus = RxBus.get();
    }

    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println(consumerName + " received " + textMessage.getText());
            bus.send(textMessage.getText());
            if ("END".equals(textMessage.getText())) {
                asyncReceiveQueueClientExample.latchCountDown();
                bus.complete();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void setAsyncReceiveQueueClientExample(
            JmsAsyncReceiveQueueClientExample asyncReceiveQueueClientExample) {
        this.asyncReceiveQueueClientExample = asyncReceiveQueueClientExample;
    }
}
