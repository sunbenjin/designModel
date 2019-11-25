package com.java.strategy;

import java.util.Arrays;

public class MainTest {


    public static void main(String[] args) {
        Cat[] arr = {new Cat(1,5),new Cat(3,6),new Cat(2,2)};
        Sorter<Cat> sorter = new Sorter<>();
       // sorter.sort(arr,new CatWeightComparator());
       // sorter.sort(arr,new CatHeightComparator());
        sorter.sort(arr,(o1,o2)->{
            if(o1.height>o2.height)
                return 1;
            if(o1.height<o2.height)
                return -1;
            return  0;
        });
        System.out.println(Arrays.toString(arr));
    }
}
