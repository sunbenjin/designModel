package com.java.chainofresponsibility;

public class SensitityFilter implements Filter {
    @Override
    public void doFilter(Msg msg) {
        String s = msg.getMsg();
        s = s.replaceAll("996","995");
        msg.setMsg(s);
    }
}
