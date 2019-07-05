package com.cao;

public class Goods {
    private final String name;
    private final String id;

    public Goods( String id,String name) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
