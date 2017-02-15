package controller;

import client.JmsQueueClient;
import client.JmsTopicClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sce on 15.02.2017.
 */
@RestController
@EnableAutoConfiguration
public class WebController {

    @Autowired
    JmsQueueClient jmsQueueClient;

    @Autowired
    JmsTopicClient jmsTopicClient;


    @RequestMapping(value="/queue/produce")
    public String queueProduce(@RequestParam("msg")String msg){
        jmsQueueClient.send(msg);
        return "Queue msg produce Done";
    }

    @RequestMapping(value="/topic/produce")
    public String topicProduce(@RequestParam("msg")String msg){
        jmsTopicClient.send(msg);
        return "Topic msg produce Done";
    }

    @RequestMapping(value="/receive")
    public String receive(){
        return jmsQueueClient.receive();
    }
    public static void main(String[] args) {
        SpringApplication.run(WebController.class,args);
    }

}
