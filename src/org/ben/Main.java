package org.ben;

import org.ben.model.Order;
import org.ben.model.OrderFactory;
import org.ben.util.ReadFile;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> rawOrders = ReadFile.readFileAsStringsPerLine("./resources/input_example.csv");
        List<Order> orders = rawOrders.stream().map(order -> OrderFactory.fromFileString(order)).collect(Collectors.toList());


        System.out.println(orders.get(0).getName());
    }
}
