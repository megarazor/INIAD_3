package org.iniad.se.sample11.sample2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FibTest {
    @Test
    public void testFib1(){
        assertThat(Fib.fib(10), is(55));
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testFib2(){
        Fib.fib(-1);
    }

    @Test (timeout = 100)
    public void testFib3(){
        Fib.fib(40);
    }
}