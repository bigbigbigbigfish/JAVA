package com.cao.day1.sjms;

public class FruitFactory {
    private FruitFactory() {

    }
    public static Fruit getFruit(String fruitName) {
        if("apple".equalsIgnoreCase(fruitName)) {
            return  new Apple();
        }
        if("orange".equalsIgnoreCase(fruitName)) {
            return  new Orange();
        }
        throw  new IllegalArgumentException(fruitName+" not found");
    }
}
