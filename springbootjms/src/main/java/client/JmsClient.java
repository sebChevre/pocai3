package client;

/**
 * Created by sce on 15.02.2017.
 */
public interface JmsClient {
    public void send(String msg);
    public String receive();
}
