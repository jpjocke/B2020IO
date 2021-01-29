package org.ben;

import org.ben.model.Average;
import org.ben.model.Order;
import org.ben.model.OrderFactory;
import org.ben.util.ReadFile;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //String fileName = "./resources/input_example.csv";
        String fileName = "./resources/order_log00.csv";
        List<String> rawOrders = ReadFile.readFileAsStringsPerLine(fileName);
        List<Order> orders = rawOrders.stream().map(OrderFactory::fromFileString).collect(Collectors.toList());

        Calculator calculator = new Calculator(orders);
        List<Average> averages = calculator.calculateAverageProduct();

        calculator.calculatePopularBrand();

        System.out.println(orders.get(0).getName());
    }
}
