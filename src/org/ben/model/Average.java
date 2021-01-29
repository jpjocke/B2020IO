package org.ben.model;

import org.ben.util.Printable;

public class Average implements Printable {
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
    public String toPrint() {
        return name + ',' + quantity;
    }
}
