package org.ben.model;

public class Order {
    private final String id;
    private final String area;
    private final String name;
    private final int quantity;
    private final String brand;

    public Order(String id, String area, String name, int quantity, String brand) {
        this.id = id;
        this.area = area;
        this.name = name;
        this.quantity = quantity;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public String getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getBrand() {
        return brand;
    }
}
