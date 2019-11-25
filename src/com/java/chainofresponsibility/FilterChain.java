package com.java.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    List<Filter> filters = new ArrayList<>();

    public  FilterChain add(Filter filter){
              filters.add(filter);
              return this;
    }
    public void doFilter (Msg m){
        for(Filter f: filters){
            f.doFilter(m);
        }
    }
}
