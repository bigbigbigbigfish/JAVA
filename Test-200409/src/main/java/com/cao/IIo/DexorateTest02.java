package com.cao.IIo;

/***
 * 模拟咖啡
 * 1 抽象组件: 需要装饰的抽象接口对象(接口或父类)
 * 具体的组件: 需要装饰的对象
 * 抽象装饰类 包含了对抽象组件的引用及装饰着共有的方法
 * 具体装饰类,被装饰的对象
 */
public class DexorateTest02 {
    public static void main(String[] args) {
        Drink coffee = new Coffee();
        Drink suger = new Suger(coffee);
        System.out.println(suger.info() + "-------" + suger.cost());
        Drink milk = new Milk(coffee);
        System.out.println(milk.info() + "-------" + milk.cost());
        milk = new Milk(suger);
        System.out.println(milk.info() + "------" + milk.cost());
    }
}

interface  Drink {
    double cost(); //费用
    String info();//说明
}
//具体组件
class Coffee implements Drink {
    private String name ="原味咖啡";
    public double cost() {

        return 10;
    }

    public String info()
    {
        return name;
    }
}


//抽象的装饰类

class Decorate implements Drink {
    private Drink drink;

    public Decorate(Drink drink) {

        this.drink = drink;
    }

    public double cost() {
        return this.drink.cost();
    }

    public String info() {

        return this.drink.info();
    }
}

class Milk extends Decorate {

    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()*4;
    }

    @Override
    public String info() {
        return super.info()+"加入了牛奶";
    }
}

class Suger extends Decorate {

    public Suger(Drink drink) {
        super(drink);
    }
    @Override
    public double cost() {
        return super.cost()*2;
    }

    @Override
    public String info() {
        return super.info()+"加入了糖";
    }
}