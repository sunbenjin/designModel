package com.java.chainofresponsibility;

public class FaceFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        String s = msg.getMsg();
        s = s.replace("(:","^|^");
        msg.setMsg(s);
        return true;
    }
}
