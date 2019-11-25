package com.java.single;

public class Single1_1 {
    private static final Single1_1 instance ;
    static {
        instance = new Single1_1();
    }
    private Single1_1(){

    }
    public Single1_1 getInstance(){
     /*    try{
           Thread.sleep(100);
        }catch (Exception e){

        }*/
       return instance;
    }

    public static void main(String[] args) {
        for (int i=0;i<1000;i++) {
            new Thread(()->{
                try{
                    Thread.sleep(1000);
                }catch (Exception e){

                }

                System.out.println(Single2.getInstance().hashCode());
            }).start();
        }

    }
}
