package app.log;

import java.io.IOException;
import java.util.logging.*;

/**
 * Created by sce on 23.02.2017.
 */
public class AppLogger {
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;

    static private FileHandler fileHTML;
    static private Formatter jsonFormatter;

    static public void setup() throws IOException {

        // get the global logger to configure it
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        logger.setLevel(Level.INFO);
        fileHTML = new FileHandler("logging.json");

        // create an HTML formatter
        jsonFormatter = new JsonLogFormatter();
        fileHTML.setFormatter(jsonFormatter);
        logger.addHandler(fileHTML);


        // suppress the logging output to the console
       Logger rootLogger = Logger.getLogger("");
       Handler[] handlers = rootLogger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            //rootLogger.removeHandler(handlers[0]);
            rootLogger.addHandler(fileHTML);
        }


    }

}
