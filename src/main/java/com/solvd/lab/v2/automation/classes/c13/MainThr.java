package com.solvd.lab.v2.automation.classes.c13;

import java.util.concurrent.Semaphore;

class EggVoice extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            try {
                sleep(1000);
            } catch(InterruptedException e){}

            System.out.println("egg!");
        }
    }
}

// mutex, monitor, semaphore, race condition
// synchronized
// scenarios - just parallel task, interaction, interaction with shared resources
// thread-safety
class MainThr {
    static EggVoice mAnotherOpinion;

//    public static void main(String[] args) {
//        mAnotherOpinion = new EggVoice();
//        System.out.println("Begin...");
//        mAnotherOpinion.start();
//
//        for(int i = 0; i < 5; i++) {
//            try {
//                Thread.sleep(1000);
//            }catch(InterruptedException e){}
//
//            System.out.println("chicken!");
//        }
//
//        if(mAnotherOpinion.isAlive()) {
//            try {
//                mAnotherOpinion.join();
//            }catch(InterruptedException e){}
//
//            System.out.println("egg!");
//        }
//        else {
//            System.out.println("chicken!");
//        }
//        System.out.println("Finish!");
//    }

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2);
        new Philosopher(sem,"Сократ").start();
        new Philosopher(sem,"Платон").start();
        new Philosopher(sem,"Аристотель").start();
        new Philosopher(sem,"Фалес").start();
        new Philosopher(sem,"Пифагор").start();
    }


}


class Philosopher extends Thread {

    private Semaphore sem;

    private boolean full = false;

    private String name;

    Philosopher(Semaphore sem, String name) {
        this.sem=sem;
        this.name=name;
    }

    public void run()
    {
        try
        {
            if (!full) {
                sem.acquire();
                System.out.println (name + " садится за стол");

                sleep(300);
                full = true;

                System.out.println (name + " поел! Он выходит из-за стола");
                sem.release();

                sleep(300);
            }
        }
        catch(InterruptedException e) {
            System.out.println ("Что-то пошло не так!");
        }
    }
}

class ProcessMaoPickupReadyInputManager {

    private static ProcessMaoPickupReadyInputManager instance;

    private ProcessMaoPickupReadyInputManager() {
    }

    public static ProcessMaoPickupReadyInputManager getInstance() {
        if (instance == null) {
            synchronized (ProcessMaoPickupReadyInputManager.class) {
                if (instance == null) {
                    instance = new ProcessMaoPickupReadyInputManager();
                }
            }
        }
        return instance;
    }
}