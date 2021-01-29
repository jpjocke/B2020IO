package org.ben;

import org.ben.model.Average;
import org.ben.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    private final List<Order> orders;

    public Calculator(List<Order> orders) {
        this.orders = orders;
    }

    public List<Average> calculateAverageProduct() {
        List<Average> averageList = new ArrayList<>();
        Map<String, Integer> sum = new HashMap<>();

        orders.forEach(order -> {
            if (sum.get(order.getName()) == null) {
                sum.put(order.getName(), order.getQuantity());
            } else {
                sum.put(order.getName(), sum.get(order.getName()) + order.getQuantity());
            }
        });

        sum.keySet().forEach(key -> {
            averageList.add(new Average(key, ((double)sum.get(key))/((double)orders.size())));
        });

        return averageList;
    }

}
