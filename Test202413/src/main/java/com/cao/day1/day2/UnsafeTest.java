package com.cao.day1.day2;

public class UnsafeTest {
    public static void main(String[] args) {
        Account account = new Account(100,"结婚礼金");
        Drawing you = new Drawing(account,80,"你");
        Drawing wife = new Drawing(account,90,"happy的她");
        you.start();
        wife.start();
    }

}

class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread {
    Account account; //取钱账户
    int drawingMoney;//取的钱数
    int packTotal;//口袋总数
    public Drawing(Account account,int drawingMoney,String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
    @Override
    public void run() {
        if(account.money - drawingMoney<0) {
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money -= drawingMoney;
        packTotal += drawingMoney;
        System.out.println(this.getName() + "----> 账户余额" + account.money);
        System.out.println(this.getName() + "----> 口袋的钱" + packTotal);

    }

}
