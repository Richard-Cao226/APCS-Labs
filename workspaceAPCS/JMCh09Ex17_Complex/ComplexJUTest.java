import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

/**
 *  Test for the complex number class.
 *  
 *  testConstructor1Param - test the 1 parameter constructor
 *  testConstructor2Param - test the 2 parameter constructor
 *  testAddRealAndComplexNum - addition of a complex number 
 *     with a real number
 *  testAdd2ComplexNums - addition of two complex numbers
 *  testMultiply2ComplexNums - multiplication of two complex numbers
 *  testMultiplyRealAndComplexNum - multiplication of a complex number
 *     with a real number
 *  testAbsoluteValue - absolute value of a complex number
 *
 *  @author  Richard Cao
 *  @version 10/4
 *  @author  Period: 3
 *  @author  Assignment: JMCh09Ex17_Complex 
 *
 *  @author  Sources: Richard Cao
 */
public class ComplexJUTest extends junit.framework.TestCase
{
    @Test
    public void testConstructor1Param()
    {
        Complex complex = new Complex(5);
        assertEquals("5.0 + 0.0i", complex.toString());
    }

    @Test
    public void testConstructor2Param()
    {
        Complex complex = new Complex(5, 6);
        assertEquals("5.0 + 6.0i", complex.toString());
    }

    @Test
    public void testAddRealAndComplexNum()
    {
        Complex complex = new Complex(5, 6);
        assertEquals("12.0 + 6.0i", complex.add(7).toString());
    }
    
    @Test
    public void testAdd2ComplexNums()
    {
        Complex complex1 = new Complex(2, 3);
        Complex complex2 = new Complex(5, 6);
        assertEquals("7.0 + 9.0i", complex1.add(complex2).toString());
    }

    @Test
    public void testMultiply2ComplexNums()
    {
        Complex complex1 = new Complex(2, 3);
        Complex complex2 = new Complex(5, 6);
        assertEquals("-8.0 + 27.0i", complex1.multiply(complex2).toString());
    }

    @Test
    public void testMultiplyRealAndComplexNum()
    {
        Complex complex = new Complex(2, 3);
        assertEquals("4.0 + 6.0i", complex.multiply(2).toString());
    }

    @Test
    public void testAbsoluteValue()
    {
        Complex complex = new Complex(3, 4);
        assertEquals(5.0, complex.abs());
    }
    
    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( ComplexJUTest.class );
    }

    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "ComplexJUTest" );
    }
}
