package com.java.chainofresponsibility;

public class FaceFilter implements Filter {
    @Override
    public void doFilter(Msg msg) {
        String s = msg.getMsg();
        s = s.replace("(:","^|^");
        msg.setMsg(s);
    }
}
