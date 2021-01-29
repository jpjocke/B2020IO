package org.ben;

import org.ben.model.Average;
import org.ben.model.Order;
import org.ben.model.PopularBrand;

import java.util.*;

/**
 * Uses business rules to calculate average and popular on specific orders.
 */
public class Calculator {
    private final List<Order> orders;

    public Calculator(List<Order> orders) {
        this.orders = orders;
    }

    /**
     * Calculates the average quantity of a product purchased per order.
     *
     * @return A list with the averages calculated.
     */
    public List<Average> calculateAverageProduct() {
        Map<String, Integer> sum = new HashMap<>();
        orders.forEach(order -> sum.merge(order.getName(), order.getQuantity(), Integer::sum));

        List<Average> averageList = new ArrayList<>();
        sum.keySet().forEach(key ->
                averageList.add(new Average(key, average(sum.get(key), orders.size())))
        );

        return averageList;
    }

    private double average(int quantity, int size) {
        return ((double) quantity / ((double) size));
    }

    /**
     * Finds out the most popular brands for all product names.
     *
     * @return A list with the most popular brands.
     */
    public List<PopularBrand> calculatePopularBrand() {
        Map<String, Map<String, PopularBrand>> sum = sumPopularBrands();
        return findMostPopularBrands(sum);
    }

    private Map<String, Map<String, PopularBrand>> sumPopularBrands() {
        Map<String, Map<String, PopularBrand>> sum = new HashMap<>();
        orders.forEach(order -> sumPopularBrandsPerOrder(sum, order.getName(), order.getBrand()));
        return sum;
    }

    private void sumPopularBrandsPerOrder(Map<String, Map<String, PopularBrand>> sum, String productName, String brand) {
        Map<String, PopularBrand> brandMap = sum.get(productName);
        if (brandMap == null) {
            brandMap = new HashMap<>();
            brandMap.put(brand, new PopularBrand(productName, brand));
            sum.put(productName, brandMap);
        } else {
            PopularBrand pb = brandMap.get(brand);
            if (pb == null) {
                pb = new PopularBrand(productName, brand);
                brandMap.put(brand, pb);
            } else {
                pb.increaseCount();
            }
        }
    }

    private List<PopularBrand> findMostPopularBrands(Map<String, Map<String, PopularBrand>> sum) {
        List<PopularBrand> popularList = new ArrayList<>();
        sum.keySet().forEach(key -> popularList.add(findMostPopularBrandPerProduct(sum.get(key))));
        return popularList;
    }

    private PopularBrand findMostPopularBrandPerProduct(Map<String, PopularBrand> products) {
        PopularBrand mostPopular = null;
        PopularBrand[] popularArray = products.values().toArray(new PopularBrand[0]);
        for (PopularBrand popularBrand : popularArray) {
            if (mostPopular == null) {
                mostPopular = popularBrand;
            } else if (popularBrand.getCount() > mostPopular.getCount()) {
                mostPopular = popularBrand;
            }
        }
        return mostPopular;
    }
}
