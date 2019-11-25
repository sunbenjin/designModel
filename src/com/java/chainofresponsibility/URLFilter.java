package com.java.chainofresponsibility;

public class URLFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        String s = msg.getMsg();
        s = s.replace("sunbenjin.online","http://www.sunbenjin.online");
        msg.setMsg(s);
        return true;
    }
}
