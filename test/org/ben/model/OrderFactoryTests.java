package org.ben.model;

import org.junit.Assert;
import org.junit.Test;

public class OrderFactoryTests {
    @Test
    public void givenPreDefinedOrderThenOrderIsCreatedCorrectly(){
        String line = "ID1,Minneapolis,shoes,2,Air";
        Order order = OrderFactory.fromFileString(line);

        Assert.assertNotNull(order);
        Assert.assertEquals("ID1", order.getId());
        Assert.assertEquals("Minneapolis", order.getArea());
        Assert.assertEquals("shoes", order.getName());
        Assert.assertEquals(2, order.getQuantity());
        Assert.assertEquals("Air", order.getBrand());
    }

}
