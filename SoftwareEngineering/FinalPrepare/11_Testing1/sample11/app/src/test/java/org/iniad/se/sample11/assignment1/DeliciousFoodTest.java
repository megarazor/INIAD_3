package org.iniad.se.sample11.assignment1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DeliciousFoodTest {
    private DeliciousFood deliciousFood;

    @Before
    public void setUp(){
        deliciousFood= new DeliciousFood("My meat", 100);
    }

    @Test
    public void testConstructor(){
        assertThat(deliciousFood.getName(), is("My meat"));
        assertThat(deliciousFood.price, is(100));
    }

    @Test
    public void testGetTaxPrice(){
        assertThat(deliciousFood.getTaxPrice(), is(108));
    }

    @Test
    public void testGetTaste(){
        assertThat(deliciousFood.getTaste(), is("Delicious"));
    }
}