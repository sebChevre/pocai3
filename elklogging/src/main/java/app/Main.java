package app;

import app.log.AppLogger;
import app.log.JsonLog;
import app.log.TextGenerator;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sce on 23.02.2017.
 */
public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());



    public static void main(String[] args) throws InterruptedException {


        Main main = new Main();

        try {
            AppLogger.setup();
        } catch (IOException e) {
            e.printStackTrace();
        }

        main.testLogs();

    }

    private void testLogs() throws InterruptedException {

        Executor exe = Executors.newFixedThreadPool(4);
        log.setLevel(Level.FINEST);

        for(int cpt = 0; cpt < 10000; cpt ++){
            exe.execute(new Runnable() {
                @Override
                public void run() {
                   generateAleatoireLevelLog();
                    try {
                        Thread.sleep((long)new Random().nextInt(3000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });


        }

    }

    private void generateAleatoireLevelLog(){
        int value = new Random().nextInt(5);
        String jsonLogMsg = generateAleatoireMsgLog();

        switch (value){
            case 0:
                log.severe(jsonLogMsg);
                break;
            case 1:
                log.info(jsonLogMsg);
                break;
            case 2:
                log.fine(jsonLogMsg);
                break;
            case 3:
                log.warning(jsonLogMsg);
                break;
            case 4:
                log.finest(jsonLogMsg);
                break;
        }
    }

    private String generateAleatoireMsgLog(){
        int value = new Random().nextInt(2);

        switch (value){
            case 0:
                return new JsonLog(TextGenerator.getMessagesAleaForType(JsonLog.MsgType.DOMAIN), JsonLog.MsgType.DOMAIN).toJson();

            case 1:
                return new JsonLog(TextGenerator.getMessagesAleaForType(JsonLog.MsgType.TECHNICAL), JsonLog.MsgType.TECHNICAL).toJson();


            default:throw new IllegalArgumentException();
        }
    }

}
