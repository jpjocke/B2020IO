package org.ben;

import org.ben.model.Average;
import org.ben.model.Order;
import org.ben.model.OrderFactory;
import org.ben.util.ReadFile;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class VerifyExamples {
    private static final String EXAMPLE_ONE_FILEPATH = "./resources/input_example.csv";
    private static final String EXAMPLE_TWO_FILEPATH = "./resources/order_log00.csv";

    @Test
    public void givenExample1ThenAverageIsCorrect(){
        List<String> rawOrders = ReadFile.readFileAsStringsPerLine(EXAMPLE_ONE_FILEPATH);
        List<Order> orders = rawOrders.stream().map(order -> OrderFactory.fromFileString(order)).collect(Collectors.toList());

        Calculator calculator = new Calculator(orders);
        List<Average> averages = calculator.calculateAverageProduct();
        Assert.assertEquals(2, averages.size());
        Assert.assertEquals(2, averages.stream().filter(average -> average.getName().equals("shoes")).collect(Collectors.toList()).get(0).getQuantity(), 0);
        Assert.assertEquals(0.75, averages.stream().filter(average -> average.getName().equals("forks")).collect(Collectors.toList()).get(0).getQuantity(), 0);
    }

    @Test
    public void givenExample2ThenAverageIsCorrect(){
        List<String> rawOrders = ReadFile.readFileAsStringsPerLine(EXAMPLE_TWO_FILEPATH);
        List<Order> orders = rawOrders.stream().map(order -> OrderFactory.fromFileString(order)).collect(Collectors.toList());

        Calculator calculator = new Calculator(orders);
        List<Average> averages = calculator.calculateAverageProduct();
        Assert.assertEquals(2, averages.size());
        Assert.assertEquals(2.4, averages.stream().filter(average -> average.getName().equals("Intelligent Copper Knife")).collect(Collectors.toList()).get(0).getQuantity(), 0);
        Assert.assertEquals(0.8, averages.stream().filter(average -> average.getName().equals("Small Granite Shoes")).collect(Collectors.toList()).get(0).getQuantity(), 0);
    }
}
