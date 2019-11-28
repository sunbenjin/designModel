package com.java.chainofresponsibility.v3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "大家好:)，<script>，欢迎访问 mashibing.com ，大家都是996 ";
        Response response = new Response();
        response.str = "response";

        FilterChain chain = new FilterChain();
        chain.add(new HtmlFilter()).add(new SensitiveFilter()).add(new FaceFilter());
        chain.doFilter(request, response, chain);
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
    boolean doFilter(Request request,Response response,FilterChain filterChain);
}
class FilterChain implements Filter{

    List<Filter> list = new ArrayList<>();
    int index=0;
    public FilterChain add(Filter filter){
        list.add(filter);
        return this;
    }
    @Override
    public boolean doFilter(Request request, Response response,FilterChain chain) {
        if(index==list.size()) return  false;
        Filter filter = list.get(index);
        index++;
        return filter.doFilter(request,response,chain);
    }
}
class HtmlFilter implements Filter{

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replaceAll("<", "[").replaceAll(">", "]") + "HTMLFilter";
        filterChain.doFilter(request,response,filterChain);
        response.str+="---htmlFilter";
        return true;
    }
}
class SensitiveFilter implements Filter{

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replaceAll("996", "995")+" sensitiveFilter";
        filterChain.doFilter(request,response,filterChain);
        response.str+="---sensitiveFilter";
        return true;
    }
}
class FaceFilter implements Filter{

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replace(":)", "`^`")+" faceFilter";
        filterChain.doFilter(request,response,filterChain);
        response.str+="---faceFilter";
        return true;
    }
}

