package org.ben.model;

public class Average {
    private final String name;
    private final double quantity;

    public Average(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return name + ',' + quantity;
    }
}
