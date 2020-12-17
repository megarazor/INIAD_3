package org.iniad.se.sample11.assignment1;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class BookTest {
    private Book book;

    @Before
    public void setUp(){
        book= new Book("Bible", 100);
    }

    @Test
    public void testConstructor(){
        assertThat(book.getName(), is("Bible"));
    }

    @Test
    public void testGetTaxPrice(){
        assertThat(book.getTaxPrice(), is(110));
    }
}