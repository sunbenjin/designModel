package com.java.strategy;

public class CatHeightComparator implements Comparator<Cat>{
    @Override
    public int compareTo(Cat o1, Cat o2) {
        if(o1.height>o2.height) return 1;
        if(o1.height<o2.height) return -1;
        return 0;
    }
}
