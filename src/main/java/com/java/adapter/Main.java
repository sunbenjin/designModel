package com.java.adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("D:/install.log");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while(line !=null && !line.equals("")){
            System.out.println(line);
            line = br.readLine();
        }
        br.close();


    }
}
