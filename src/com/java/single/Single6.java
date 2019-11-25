package com.java.single;

public class Single6 {
    private Single6(){

    }
    private static class Single6Holder{
        private final static Single6 instance = new Single6();
    }

    public static Single6 getInstance(){
        return Single6Holder.instance;
    }
    public static void main(String[] args) {
        for(int i=0; i<100; i++){
            new Thread(()->{
                System.out.println(Single6.getInstance().hashCode());
            }).start();
        }
    }
}
