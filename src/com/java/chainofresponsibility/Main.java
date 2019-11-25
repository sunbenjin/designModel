package com.java.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("hello (: , <script> sunbenjin.online，我是996");
        msg.setName("领导");
       /* List<Filter> list = new ArrayList<>();
        Filter htmlFilter = new HtmlFilter();
        list.add(htmlFilter);
        Filter sensitityFilter = new SensitityFilter();
        list.add(sensitityFilter);
        for(Filter f : list){
            f.doFilter(msg);*/
       FilterChain fc = new FilterChain();
       fc.add(new HtmlFilter()).add(new SensitityFilter());
       FilterChain fc1 = new FilterChain();
       fc1.add(new FaceFilter()).add(new URLFilter());
      /* fc1.doFilter(msg);
        fc.doFilter(msg);*/
      fc.add(fc1);
      fc.doFilter(msg);
        System.out.println(msg);
    }
}
