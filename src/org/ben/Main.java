package org.ben;

import org.ben.model.Average;
import org.ben.model.Order;
import org.ben.model.OrderFactory;
import org.ben.model.PopularBrand;
import org.ben.util.FileHelper;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String fileName = "input_example.csv";
        //String fileName = "order_log00.csv";
        String filePath = "./resources/" + fileName;
        List<String> rawOrders = FileHelper.readFileAsStringsPerLine(filePath);
        List<Order> orders = rawOrders.stream().map(OrderFactory::fromFileString).collect(Collectors.toList());

        Calculator calculator = new Calculator(orders);
        List<Average> averages = calculator.calculateAverageProduct();
        List<PopularBrand> popularBrands = calculator.calculatePopularBrand();

        FileHelper.printToFile("0_" + fileName, averages);
        FileHelper.printToFile("1_" + fileName, popularBrands);
    }
}
