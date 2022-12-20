package org.example;

public class Menuitem {
    private final String name;
    private final int price;

    public Menuitem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean matches(String name) {
        return false;
    }
}
