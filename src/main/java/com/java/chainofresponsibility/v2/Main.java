package com.java.chainofresponsibility.v2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "大家好:)，<script>，欢迎访问 mashibing.com ，大家都是996 ";
        Response response = new Response();
        response.str = "response";
        FilterChain chain = new FilterChain();
        chain.add(new HtmlFilter()).add(new SensitiveFilter());
        chain.doFilter(request,response);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}
class Request{
    String str;
}
class Response{
    String str;
}
interface Filter{
    boolean doFilter(Request request,Response response);
}
class HtmlFilter implements Filter{

    @Override
    public boolean doFilter(Request request, Response response) {
        request.str = request.str.replaceAll("<","[").replaceAll(">","]");
        response.str +="--htmlFilter--";
        return true;
    }
}
class SensitiveFilter implements Filter{

    @Override
    public boolean doFilter(Request request, Response response) {
        request.str = request.str.replaceAll("996","995");
        response.str +="--sensitiveFilter--";
        return true;
    }
}
class FilterChain implements Filter{
    List<Filter> lists = new ArrayList<>();

    public FilterChain add(Filter filter){
        lists.add(filter);
        return this;
    }
    @Override
    public boolean doFilter(Request request, Response response) {
        for(Filter f: lists){
            f.doFilter(request,response);
        }
        return true;
    }
}
