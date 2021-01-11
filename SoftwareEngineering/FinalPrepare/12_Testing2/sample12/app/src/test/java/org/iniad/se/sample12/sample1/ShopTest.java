package org.iniad.se.sample12.sample1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShopTest {
    private Shop shop;
    private Seller seller;
    private Customer customer;
    private Item item;

    @Before
    public void init() {
        shop = new Shop();
        seller = new Seller("Tanaka", "Tocho");
        customer = new Customer("Taro");
        item = new Item(seller, "Ramen", 400);
        shop.register(item);
    }

    @Test
    public void testBuy1() throws ShopException {
        customer.charge(500);
        Item bought = shop.buy(customer, "Ramen");
        assertThat(bought, is(item));
        assertThat(seller.getBalance(), is(400));
        assertThat(customer.getBalance(), is(100));
    }

    @Test(expected = ShopException.class)
    public void testBuy2() throws ShopException {
        customer.charge(300);
        Item bought = shop.buy(customer, "Ramen");
    }

    @Test(expected = ShopException.class)
    public void testBuy3() throws ShopException {
        customer.charge(500);
        Item bought = shop.buy(customer, "Noodle");
    }
}