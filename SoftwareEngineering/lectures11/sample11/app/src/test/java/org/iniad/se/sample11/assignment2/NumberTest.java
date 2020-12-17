package org.iniad.se.sample11.assignment2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumberTest{
    private Number n;

    @Before
    public void setUp(){
        n= new Number(13.0f);
    }

    @Test
    public void testEval(){
        assertThat(n.eval(), is(13.0f));
    }
}