package org.iniad.se.sample11.assignment2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OperatorTest{
    @Test
    public void testEval1(){
        Operator o= new Operator("+");
        o.add(new Number(5.0f));
        o.add(new Number(3.0f));
        assertThat(o.eval(), is(8.0f));
    }

    @Test
    public void testEval2(){
        Operator o= new Operator("-");
        o.add(new Number(5.0f));
        o.add(new Number(3.0f));
        assertThat(o.eval(), is(2.0f));
    }

    @Test
    public void testEval3(){
        Operator o= new Operator("*");
        o.add(new Number(5.0f));
        o.add(new Number(3.0f));
        assertThat(o.eval(), is(15.0f));
    }

    @Test
    public void testEval4(){
        Operator o= new Operator("/");
        o.add(new Number(6.0f));
        o.add(new Number(2.0f));
        assertThat(o.eval(), is(3.0f));
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testEval5(){
        Operator o= new Operator("/");
        o.add(new Number(6.0f));
        o.eval();
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testEval6(){
        Operator o= new Operator("%");
        o.add(new Number(6.0f));
        o.add(new Number(2.0f));
        o.eval();
    }

    @Test
    public void testGetChild(){
        Operator o= new Operator("%");
        o.add(new Number(6.0f));
        o.add(new Number(2.0f));
        assertThat(o.getChild(0).eval(), is(6.0f));
        assertThat(o.getChild(1).eval(), is(2.0f));
    }
}