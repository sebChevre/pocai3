package ch.sebooom.pocjms.domain.message;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public interface Publisher<T>{

    void publish(T message);
}
