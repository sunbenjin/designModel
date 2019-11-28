package com.java.bridge;

public class Main {

}
class GG{
    public void chase(MM mm){
        Gift g = new WarmGift(new Book());

    }
    public void give(MM mm,Gift g){
        System.out.println(g + "gived");
    }
}
class MM{

    String name;
}
abstract class Gift{
    GiftImpl impl;
}
class GiftImpl{

}
class WarmGift extends Gift{
    public WarmGift(GiftImpl impl){
        this.impl = impl;
    }

}
class WildGift extends Gift{
    public WildGift(GiftImpl impl){
        this.impl = impl;
    }

}
class Book extends GiftImpl{

}
class Flower extends GiftImpl{

}

