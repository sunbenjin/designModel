package com.java.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("hello , <script> 你好，我是996");
        msg.setName("领导");
        List<Filter> list = new ArrayList<>();
        Filter htmlFilter = new HtmlFilter();
        list.add(htmlFilter);
        Filter sensitityFilter = new SensitityFilter();
        list.add(sensitityFilter);
        for(Filter f : list){
            f.doFilter(msg);
        }
        System.out.println(msg);
    }
}
