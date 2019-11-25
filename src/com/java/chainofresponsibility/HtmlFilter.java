package com.java.chainofresponsibility;

public class HtmlFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        String s = msg.getMsg();
        s = s.replaceAll("<","[").replaceAll(">","]");
        msg.setMsg(s);
        return true;
    }
}
