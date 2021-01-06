package com.example.simpletest.sample1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CircleTest {
    private Circle c1;

    @BeforeClass
    public static void testBeforeClass(){
        System.out.println("@Test: testBeforeClass");
    }

    @AfterClass
    public static void testAfterClass(){
        System.out.println("@Test: testAfterClass");
    }

    @Before
    public void testBeforeTestMethod(){
        System.out.println("@Before");
        c1= new Circle(10.0, "Red");
    }

    @After
    public void testAfterTestMethod(){
        System.out.println("After");
    }

    @Test
    public void testConstructor(){
        System.out.println("@Test: testConstructor");
        assertThat(c1.getRadius(), is(10.0));
        assertThat(c1.getColor(), is("Red"));
    }

    @Test
    public void testGetRadius(){
        System.out.println("@Test: testGetRadius");
        assertThat(c1.getRadius(), is(10.0));
    }

    @Test
    public void testGetArea(){
        System.out.println("@Test: testGetArea");
        assertThat(c1.getArea(), is(Math.PI * c1.getRadius() * c1.getRadius()));
    }
}