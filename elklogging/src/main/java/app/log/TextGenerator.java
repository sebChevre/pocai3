package app.log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sce on 23.02.2017.
 */
public class TextGenerator {

    private static List<String> exceptionsmessages = new ArrayList<>();
    private static List<String> domainEventsmessages = new ArrayList<>();

    static{

        exceptionsmessages.add("IllegalsArgumentException exception");
        exceptionsmessages.add("NullPointerException : null");
        exceptionsmessages.add("NullPointerException : null");
        exceptionsmessages.add("IllegalsArgumentException exception");
        exceptionsmessages.add("NullPointerException : null");
        exceptionsmessages.add("IllegalsArgumentException exception");
        exceptionsmessages.add("NullPointerException : null");
        exceptionsmessages.add("IllegalsArgumentException exception");
        exceptionsmessages.add("IllegalArgumentException : null");

        domainEventsmessages.add("Folder created");
        domainEventsmessages.add("Tiers created");
        domainEventsmessages.add("Tiers updated");
        domainEventsmessages.add("Folder updated");
        domainEventsmessages.add("Folder created");
        domainEventsmessages.add("Folder created");

    }

    public static String getMessagesAleaForType(JsonLog.MsgType type){

        int bound;
        int alea;

        switch (type){
            case DOMAIN:
                bound = domainEventsmessages.size();
                alea = new Random().nextInt(bound);
                return domainEventsmessages.get(alea);

            case TECHNICAL:
                bound = exceptionsmessages.size();
                alea = new Random().nextInt(bound);
                return exceptionsmessages.get(alea);
            default:
                throw new IllegalArgumentException();
        }


    }
}
