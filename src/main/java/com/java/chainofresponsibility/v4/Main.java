package com.java.chainofresponsibility.v4;


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
        chain.doFilter(request, response);
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
    void doFilter(Request request, Response response, FilterChain filterChain);
}
class FilterChain {
    List<Filter> filters = new ArrayList<>();
    int index=0;
    public FilterChain add(Filter filter){
        filters.add(filter);
        return this;
    }
    public void doFilter(Request request,Response response){
        if(index==filters.size()){
            return;
        }
        Filter filter = filters.get(index);
        index++;
         filter.doFilter(request,response,this);
    }
}
class SensitiveFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replaceAll("996", "995")+" sensitiveFilter";
        filterChain.doFilter(request,response);
        response.str+="---sensitiveFilter";

    }
}
class HtmlFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replaceAll("<", "[").replaceAll(">", "]") + "HTMLFilter";
        filterChain.doFilter(request,response);
        response.str+="---htmlFilter";

    }
}
class FaceFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replace(":)", "`^`")+" faceFilter";
        filterChain.doFilter(request,response);
        response.str+="---faceFilter";

    }
}
