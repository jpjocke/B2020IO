package org.ben.model;

public class PopularBrand {
    private final String name;
    private final String brand;
    private int count;

    public PopularBrand(String name, String brand) {
        this.name = name;
        this.brand = brand;
        count = 1;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        count++;
    }

    @Override
    public String toString() {
        return "PopularBrand{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", count=" + count +
                '}';
    }
}
