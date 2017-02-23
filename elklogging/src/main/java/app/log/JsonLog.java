package app.log;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.logging.LogRecord;

/**
 * Created by sce on 23.02.2017.
 */
public class JsonLog {


    public String msg;
    public MsgType msgType;


    public enum MsgType {
        TECHNICAL, DOMAIN
    }

    public JsonLog(String msg, MsgType type){
        this.msg = msg;
        this.msgType = type;
    }

    public String toJson(){
        JsonObject obj = new JsonObject();
        obj.addProperty("msgType",msgType.toString());
        obj.addProperty("msg",msg);
        return obj.toString();
    }
}
