package org.iniad.se.sample11.sample1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;

public class UserTest{
    private User user;

    @Before
    public void setUp(){
        user= new User("Enryo", "Inoue", LocalDate.of(2000, 3, 18));
    }

    @Test
    public void testConstructor(){
        assertThat(user.getFirstName(), is("Enryo"));
        assertThat(user.getFamilyName(), is("Inoue"));
    }

    @Test
    public void testGetName(){
        assertThat(user.getName(), is("Enryo Inoue"));
    }

    @Test public void testGetAge(){
        assertThat(user.getAge(LocalDate.of(2017, 6, 6)), is (17));
    }
}