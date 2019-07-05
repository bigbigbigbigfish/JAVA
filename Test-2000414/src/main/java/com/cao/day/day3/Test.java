package com.cao.day.day3;

public class Test {
    public static void main(String[] args) {
     Fruit fruit = FruitFactory.getInstance("com.cao.day.day3.Orange");
     fruit.eat();
    }
}


interface Fruit {
    void eat();
}

class Apple implements Fruit {

    public void eat() {
        System.out.println("[Apple] 吃苹果");
    }
}

class Orange implements Fruit {
    public void eat() {
        System.out.println("[Orange] 吃橘子");
    }
}


class FruitFactory {
    private FruitFactory() {}
    public static Fruit getInstance(String className) {
        Fruit fruit = null;
        try {
            fruit = (Fruit) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  fruit;
    }
}

