package com.java.proxy.proxy6;

import java.util.Random;

public class Tank {
    public void move(){
        System.out.println("tank is moving...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
