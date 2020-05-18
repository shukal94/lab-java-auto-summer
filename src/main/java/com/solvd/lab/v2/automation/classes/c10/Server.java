package com.solvd.lab.v2.automation.classes.c10;

import com.solvd.lab.v2.automation.classes.c10.bo.ConnectMessage;
import com.solvd.lab.v2.automation.classes.c10.bo.ResponseMessage;
import com.solvd.lab.v2.automation.constant.TimeConstant;
import com.solvd.lab.v2.automation.io.impl.stream.ObjectReader;
import com.solvd.lab.v2.automation.io.interfaces.Packable;
import com.solvd.lab.v2.automation.util.SerializationUtil;

import javax.print.DocFlavor;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Server {
    private static final Logger LOGGER = Logger.getLogger(Server.class.getSimpleName());

    private static final List<String> AVAILABLE_CLIENTS = Arrays.asList("user");
    private static final String HOST = "127.0.0.1";
    private static final int PORT1 = 8000;
    private static final int PORT2 = 7000;


    public static void main(String[] args) {
        LOGGER.info(String.format("Listening on %s:%d:%d", HOST, PORT1, PORT2));
        while (true) {
            try {
                listen();
                Thread.sleep(TimeConstant.TIME_TO_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: filter msgs
    private static void listen() {

        Packable obj1 = SerializationUtil.readObject(SerializationUtil.getREADER1());
        Packable obj2 = SerializationUtil.readObject(SerializationUtil.getREADER2());
        Packable[] obje = {obj1, obj2};

        for(Packable obj:obje){
            if (obj != null) {
                ConnectMessage msg = (ConnectMessage) obj;
                if (msg.getHost().equals(HOST) && msg.getPort() == PORT1 && AVAILABLE_CLIENTS.contains(msg.getToken())) {
                    LOGGER.info(msg.getMessage());
                    Packable resp = new ResponseMessage(HOST, PORT2, "", msg.getMessage(), 200);
                    if(obj == obje[0]){
                        sendResponse(resp, SerializationUtil.getREADER1());
                    } else sendResponse(resp, SerializationUtil.getREADER2());
                }
            }
        }

    }

    private static void sendResponse(Packable pkg, ObjectReader objr) {
        SerializationUtil.writeResponse(pkg, objr);
    }

}