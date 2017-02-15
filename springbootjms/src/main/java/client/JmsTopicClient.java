package client;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public interface JmsTopicClient {
    public void send(String msg);
    public String receive();
}
