package com.solvd.lab.v2.automation.classes.c10;

import com.solvd.lab.v2.automation.classes.c10.bo.ConnectMessage;
import com.solvd.lab.v2.automation.classes.c10.bo.ResponseMessage;
import com.solvd.lab.v2.automation.constant.TimeConstant;
import com.solvd.lab.v2.automation.io.interfaces.Packable;
import com.solvd.lab.v2.automation.util.SerializationUtil;

public class Chat {
    public static void main(String[] args) {
        while (true) {
            Packable obj1 = SerializationUtil.readObject(SerializationUtil.getREADER_RESPONSE1());
            Packable obj2 = SerializationUtil.readObject(SerializationUtil.getREADER_RESPONSE2());
            Packable[] obje = {obj1, obj2};
            for(Packable obj:obje){
                if(obj == null) System.out.println("Stop!");
                if (obj != null) {
                    try {
                        Thread.sleep(TimeConstant.TIME_TO_DELAY+1000);
                        if(obj == obje[0]){
                            System.out.println(((ResponseMessage) Client1.getResponse()).getResp());
                        } else System.out.println(((ResponseMessage) Client2.getResponse()).getResp());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
