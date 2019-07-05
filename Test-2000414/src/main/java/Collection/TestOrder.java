package Collection;



import java.util.ArrayList;
import java.util.List;

class Order{
    private String title;
    private double price;
    private int amout;

    public Order(String title, double price, int amout) {
        this.title = title;
        this.price = price;
        this.amout = amout;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }
}
public class TestOrder {
    public static void main(String[] args) {
        List<Order> list = new ArrayList<>();
        list.add(new Order("iphone",8999.89,10));
        list.add(new Order("MacBookPro", 18999.99, 5));
        list.add(new Order("Java从入门到放弃.txt", 9.99, 20000));
        list.add(new Order("中性笔", 1.99, 200000));
        double allPrice = list.stream().map((obj) ->obj.getPrice()*obj.getAmout()).reduce((sum,x) ->sum +x).get();
        System.out.println(allPrice);
    }

}
