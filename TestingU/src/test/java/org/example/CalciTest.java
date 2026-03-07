<<<<<<< HEAD
package org.example;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;


public class CalciTest {
    Calculator calculator=new Calculator();

    @Test
    public void testAdd(){
        assertEquals(6,calculator.Add(3,3));
    }
    @Test
    public void testSub(){
        assertEquals(2,calculator.Sub(5,3));
    }

    @Test
    public void testMul(){
        assertEquals(15,calculator.Mul(5,3));
    }

    @Test
    public void testDiv(){
        assertEquals(5,calculator.Div(15,3));
    }
}
=======
package org.example;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;


public class CalciTest {
    Calculator calculator=new Calculator();

    @Test
    public void testAdd(){
        assertEquals(6,calculator.Add(3,3));
    }
    @Test
    public void testSub(){
        assertEquals(2,calculator.Sub(5,3));
    }

    @Test
    public void testMul(){
        assertEquals(15,calculator.Mul(5,3));
    }

    @Test
    public void testDiv(){
        assertEquals(5,calculator.Div(15,3));
    }
}
>>>>>>> ae9c5601946bc87c5ebd0e1003e56754fb6a16c2
