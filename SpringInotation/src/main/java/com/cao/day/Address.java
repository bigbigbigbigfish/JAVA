package com.cao.day;

public class Address {
    private String city;
    String Stree;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStree() {
        return Stree;
    }

    public void setStree(String stree) {
        Stree = stree;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", Stree='" + Stree + '\'' +
                '}';
    }
}
