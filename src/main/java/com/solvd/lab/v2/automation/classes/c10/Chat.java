package com.solvd.lab.v2.automation.classes.c10;

import com.solvd.lab.v2.automation.classes.c10.bo.ConnectMessage;
import com.solvd.lab.v2.automation.classes.c10.bo.ResponseMessage;
import com.solvd.lab.v2.automation.constant.TimeConstant;
import com.solvd.lab.v2.automation.io.impl.stream.ObjectReader;
import com.solvd.lab.v2.automation.io.interfaces.Packable;
import com.solvd.lab.v2.automation.util.SerializationUtil;

public class Chat {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Packable obj1 = SerializationUtil.readObject(SerializationUtil.getREADER_RESPONSE1());
            Packable obj2 = SerializationUtil.readObject(SerializationUtil.getREADER_RESPONSE2());
            Packable[] obje = {obj1, obj2};
            for(Packable obj:obje){
                if (obj != null) {
                        if(obj == obje[0]){
                            System.out.println("client 2: "+((ResponseMessage) Client1.getResponse()).getResp());
                            SerializationUtil.writeObject(null, SerializationUtil.getREADER_RESPONSE1().getPath());
                        } else {
                            System.out.println("client 1: "+((ResponseMessage) Client2.getResponse()).getResp());
                            SerializationUtil.writeObject(null, SerializationUtil.getREADER_RESPONSE2().getPath());
                        }
                }
            }

        }
    }
}
