/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstjunittest;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 *
 * @author user
 */
public class MyFirstJUnitTestTest {
    
    public MyFirstJUnitTestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class MyFirstJUnitTest.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int x = 5;
        int y = 2;
        MyFirstJUnitTest instance = new MyFirstJUnitTest();
        int expResult = 7;
        int result = instance.add(x, y);
        assertEquals(expResult, result);
       
        
    }

    /**
     * Test of subtract method, of class MyFirstJUnitTest.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        int x = 5;
        int y = 2;
        MyFirstJUnitTest instance = new MyFirstJUnitTest();
        int expResult = 3;
        int result = instance.subtract(x, y);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of multiply method, of class MyFirstJUnitTest.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        double x = 5.0;
        double y = 2.0;
        MyFirstJUnitTest instance = new MyFirstJUnitTest();
        double expResult = 10.0;
        double result = instance.multiply(x, y);
        assertEquals(expResult, result, 0.0);
    
    }

    /**
     * Test of mod method, of class MyFirstJUnitTest.
     */
    @Test
    public void testMod() {
        System.out.println("mod");
        int base = 5;
        int mod = 2;
        MyFirstJUnitTest instance = new MyFirstJUnitTest();
        int expResult = 1;
        int result = instance.mod(base, mod);
        assertEquals(expResult, result);
        /*MyFirstJUnitTest instance = new MyFirstJUnitTest();
        Integer actual = new Integer(instance.mod(5, 3));*/
     
    }

    /**
     * Test of pow method, of class MyFirstJUnitTest.
     */
    @Test
    public void testPow() {
        System.out.println("pow");
        double base = 5.0;
        double power = 2.0;
        MyFirstJUnitTest instance = new MyFirstJUnitTest();
        double expResult = 25.0;
        double result = instance.pow(base, power);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of average method, of class MyFirstJUnitTest.
     */
    @Test
    public void testAverage_List() {
        System.out.println("average");
        /*List<Integer> intList = new ArrayList<>();
        intList.add(5);
        intList.add(2);
        MyFirstJUnitTest instance = new MyFirstJUnitTest();
        double expResult = 3.5;
        double result = instance.average(intList);
        assertEquals(expResult, result, 0.0);*/
        MyFirstJUnitTest instance = new MyFirstJUnitTest();
        List<Integer> intList = new ArrayList<Integer>();
        for(int i = 0; i < 5; i++){
            intList.add(i);
        }
        double expected = 2.0;
        double actual = instance.average(intList);
        
        assertEquals(expected, actual);
    }
    
    @Test(expected = NullPointerException.class)
    public void testAverageListNull(){
        MyFirstJUnitTest instance = new MyFirstJUnitTest();
      List<Integer> intList = null;
      instance.average(intList);
    }

    /**
     * Test of cast method, of class MyFirstJUnitTest.
     */
   @Test
    public void testCast() {
        System.out.println("cast");
        Class expected = String.class;
        Object expectedObj = "MyFirstJUnitTest";
        
        MyFirstJUnitTest instance = new MyFirstJUnitTest();
        Object actual = instance.cast(expectedObj, expected);
        
        assertTrue(actual instanceof String);
    }
    
    @Test(expected = ClassCastException.class)
    public void testCastException() {
        Class c = Integer.class;
        Object o = "Test";
        MyFirstJUnitTest instance = new MyFirstJUnitTest();
        Integer i = (Integer) instance.cast(o, c);
    }
    
    /**
     * Test of average method, of class MyFirstJUnitTest.
     */
    @Test
    public void testAverage_int_int() {
        System.out.println("average");
        int a = 5;
        int b = 2;
        MyFirstJUnitTest instance = new MyFirstJUnitTest();
        double expResult = 3.5;
        
        double result = instance.average(a, b);
        assertEquals(expResult, result, 0.0);
        }

    /**
     * Test of getLetterGrade method, of class MyFirstJUnitTest.
     */
    @Test
    public void testGetLetterGrade() {
        System.out.println("getLetterGrade");
        double mark = 90.0;
        MyFirstJUnitTest instance = new MyFirstJUnitTest();
        char expResult = 'A';
        char result = instance.getLetterGrade(mark);
        assertEquals(expResult, result);
     }

    /**
     * Test of divide method, of class MyFirstJUnitTest.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        int i1 = 5;
        int i2 = 2;
        MyFirstJUnitTest instance = new MyFirstJUnitTest();
        double expResult = 2.0;
        double result = instance.divide(i1, i2);
        assertEquals(expResult, result, 0.0);
      }
    
}
