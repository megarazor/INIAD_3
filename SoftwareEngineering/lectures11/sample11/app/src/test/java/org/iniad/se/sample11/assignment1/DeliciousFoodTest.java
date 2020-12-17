package org.iniad.se.sample11.assignment1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class DeliciousFoodTest{
    private DeliciousFood food;

    @Before
    public void setUp(){
        food= new DeliciousFood("Cup ramen", 100);
    }

    @Test
    public void testConstructor(){
        assertThat(food.getName(), is("Cup ramen"));
    }

    @Test
    public void testGetTaxPrice(){
        assertThat(food.getTaxPrice(), is(108));
    }

    @Test
    public void testGetTaste(){
        assertThat(food.getTaste(), is("Delicious"));
    }
}