package ch.sebooom.pocjms.infrastructure.jms.queue.consumer.async;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class RxBus {

    private  static RxBus rxBus;
    private final Subject<Object,Object> bus = new SerializedSubject<>(PublishSubject.create());


    private RxBus(){}

    public void send(Object message){
        bus.onNext(message);
    }

    public Observable<Object> toObservable () {
        return bus;
    }

    public static RxBus get() {
        if(null == rxBus){
            rxBus = new RxBus();
        }
        return rxBus;
    }

    public void complete(){
        bus.onCompleted();
    }
}
