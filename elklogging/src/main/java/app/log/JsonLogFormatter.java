package app.log;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.JsonAdapter;
;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import static javafx.scene.input.KeyCode.G;

/**
 * Created by sce on 23.02.2017.
 */
public class JsonLogFormatter extends Formatter{

    GsonBuilder gsonBuilder = new GsonBuilder();



    @Override
    public String format(LogRecord record) {

        gsonBuilder.registerTypeAdapter(LogRecord.class, new JsonLogAdapter());//.setPrettyPrinting();

        return new StringBuilder(gsonBuilder.create().toJson(record)).append("\n").toString();
    }
}
