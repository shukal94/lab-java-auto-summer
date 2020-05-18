package com.solvd.lab.v2.automation.classes.c10;

import com.solvd.lab.v2.automation.classes.c10.bo.ConnectMessage;
import com.solvd.lab.v2.automation.classes.c10.bo.ResponseMessage;
import com.solvd.lab.v2.automation.constant.C10Constant;
import com.solvd.lab.v2.automation.io.interfaces.Packable;
import com.solvd.lab.v2.automation.util.PropertyUtil;
import com.solvd.lab.v2.automation.util.SerializationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        final String HOST = PropertyUtil.getValueByKey(C10Constant.HOSTNAME);
        final int PORT = Integer.valueOf(PropertyUtil.getValueByKey(C10Constant.PORT));
        final String TOKEN = PropertyUtil.getValueByKey(C10Constant.TOKEN);

        String path = "src/main/resources/client2";
        Path p = Paths.get(path);
        try {
            Files.createFile(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            connect(HOST, PORT, TOKEN);
            String hey = ((ResponseMessage) getResponse()).getResp();
            System.out.println(hey);
        }
    }

    private static void connect(final String host, final int port, final String token) {
        Scanner scan = new Scanner(System.in);
        System.out.print("you: ");
        String msg = scan.next();
        Packable pkg = new ConnectMessage(host, port, token, msg);
        SerializationUtil.writeObject(pkg, "src/main/resources/client2");
    }

    private static Packable getResponse() {
        return SerializationUtil.readResponse(SerializationUtil.getREADER2());
    }
}
