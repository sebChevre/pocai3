package controller;

import client.JmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sce on 15.02.2017.
 */
@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = "client.impl")
public class WebController {

    @Autowired
    JmsClient jsmClient;

    @RequestMapping(value="/produce")
    public String produce(@RequestParam("msg")String msg){
        jsmClient.send(msg);
        return "Done";
    }

    @RequestMapping(value="/receive")
    public String receive(){
        return jsmClient.receive();
    }
    public static void main(String[] args) {
        SpringApplication.run(WebController.class,args);
    }

}
