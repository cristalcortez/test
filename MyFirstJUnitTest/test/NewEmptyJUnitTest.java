/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import myfirstjunittest.MyFirstJUnitTest;
import org.junit.After;
import org.junit.AfterClass;
//import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author user
 */
public class NewEmptyJUnitTest {
    
    private MyFirstJUnitTest testObject;
    
    public NewEmptyJUnitTest() {}
    
    @Before
    public void init() {
        testObject = new MyFirstJUnitTest();
    }
    
    @After
    public void tearDown() {}

     /*@Test
     public void test() {
        
         int x = 1;
         int y = 3;
         
         double expected = 2.0;
         
         double actual = testObject.average(x, y);
         
         assertEquals(expected,actual);
     }*/
     
    /* @Test
     public void test2(){
     
         //Test 'A'
         char expected = 'A';
         char actual = testObject.getLetterGrade(80.0);
         
         assertEquals(expected,actual);
         
         //Test 'B'
         expected = 'B';
         actual = testObject.getLetterGrade(70.0);
         
         assertEquals(expected,actual);
         
         //Test 'C'
         expected = 'C';
         actual = testObject.getLetterGrade(60.0);
         
         assertEquals(expected,actual);
         
        
         expected = 'D';
         actual = testObject.getLetterGrade(50.0);
         
         assertEquals(expected,actual);
         
         expected = 'F';
         actual = testObject.getLetterGrade(40.0);
         
         assertEquals(expected,actual);
         
     }*/
     
    /* @Test
     public void testDivide(){
     
         double x = 1.0;
         double y = 2.0;
         
         double expected = 0.5;
         double actual = testObject.divide(x, y);
         
         assertTrue(expected == actual);
     
     }*/
     
     @Test(expected = ArithmeticException.class)
     public void testDivideException(){
     
         int x = 1;
         int y = 0;
         
         testObject.divide(x, y); 
    
     
     }
}
