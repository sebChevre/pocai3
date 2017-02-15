package main;

import client.ClientPackageMarker;
import config.JmsConfig;
import consumer.ConsumerPackageMarker;
import controller.ControllerPackageMarker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import producer.ProducerPackageMarker;

/**
 * Created by sce on 15.02.2017.
 */



@SpringBootApplication
@ComponentScan(basePackageClasses = {
        ClientPackageMarker.class,
        ConsumerPackageMarker.class,
        ProducerPackageMarker.class,
        ControllerPackageMarker.class,
        JmsConfig.class
})

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
