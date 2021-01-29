package org.ben;

import org.ben.model.Average;
import org.ben.model.Order;
import org.ben.model.OrderFactory;
import org.ben.model.PopularBrand;
import org.ben.util.FileHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class VerifyExamples {
    private static final String EXAMPLE_ONE_FILEPATH = "./resources/input_example.csv";
    private static final String EXAMPLE_TWO_FILEPATH = "./resources/order_log00.csv";

    @Test
    public void givenExample1ThenAverageIsCorrect(){
        List<String> rawOrders = FileHelper.readFileAsStringsPerLine(EXAMPLE_ONE_FILEPATH);
        List<Order> orders = rawOrders.stream().map(OrderFactory::fromFileString).collect(Collectors.toList());

        Calculator calculator = new Calculator(orders);
        List<Average> averages = calculator.calculateAverageProduct();
        Assert.assertEquals(2, averages.size());
        Assert.assertEquals(2, averages.stream().filter(average -> average.getName().equals("shoes")).collect(Collectors.toList()).get(0).getQuantity(), 0);
        Assert.assertEquals(0.75, averages.stream().filter(average -> average.getName().equals("forks")).collect(Collectors.toList()).get(0).getQuantity(), 0);
    }

    @Test
    public void givenExample1ThenPopularIsCorrect(){
        List<String> rawOrders = FileHelper.readFileAsStringsPerLine(EXAMPLE_ONE_FILEPATH);
        List<Order> orders = rawOrders.stream().map(OrderFactory::fromFileString).collect(Collectors.toList());

        Calculator calculator = new Calculator(orders);
        List<PopularBrand> popularList = calculator.calculatePopularBrand();
        Assert.assertEquals(2, popularList.size());
        Assert.assertEquals("Air", popularList.stream().filter(popular -> popular.getName().equals("shoes")).collect(Collectors.toList()).get(0).getBrand());
        Assert.assertEquals("Pfitzcraft", popularList.stream().filter(average -> average.getName().equals("forks")).collect(Collectors.toList()).get(0).getBrand());
    }

    @Test
    public void givenExample2ThenAverageIsCorrect(){
        List<String> rawOrders = FileHelper.readFileAsStringsPerLine(EXAMPLE_TWO_FILEPATH);
        List<Order> orders = rawOrders.stream().map(OrderFactory::fromFileString).collect(Collectors.toList());

        Calculator calculator = new Calculator(orders);
        List<Average> averages = calculator.calculateAverageProduct();
        Assert.assertEquals(2, averages.size());
        Assert.assertEquals(2.4, averages.stream().filter(average -> average.getName().equals("Intelligent Copper Knife")).collect(Collectors.toList()).get(0).getQuantity(), 0);
        Assert.assertEquals(0.8, averages.stream().filter(average -> average.getName().equals("Small Granite Shoes")).collect(Collectors.toList()).get(0).getQuantity(), 0);
    }

    @Test
    public void givenExample2ThenPopularIsCorrect(){
        List<String> rawOrders = FileHelper.readFileAsStringsPerLine(EXAMPLE_TWO_FILEPATH);
        List<Order> orders = rawOrders.stream().map(OrderFactory::fromFileString).collect(Collectors.toList());

        Calculator calculator = new Calculator(orders);
        List<PopularBrand> popularList = calculator.calculatePopularBrand();
        Assert.assertEquals(2, popularList.size());
        Assert.assertEquals("Hilll-Gorczany", popularList.stream().filter(popular -> popular.getName().equals("Intelligent Copper Knife")).collect(Collectors.toList()).get(0).getBrand());
        Assert.assertEquals("Rowe and Legros", popularList.stream().filter(average -> average.getName().equals("Small Granite Shoes")).collect(Collectors.toList()).get(0).getBrand());
    }
}
