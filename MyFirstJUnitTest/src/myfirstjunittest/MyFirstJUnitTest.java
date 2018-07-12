/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstjunittest;

import java.util.List;


/**
 *
 * @author user
 */
public class MyFirstJUnitTest {

    public int add(int x, int y){
      return x + y;
    }
    
    public int subtract(int x, int y){
      return x - y;
    }
    
    public double multiply(double x, double y){
      return x * y;
    }
    
    public int mod(int base, int mod){
      return base % mod;
    }
    
    public double pow(double base, double power){
      return Math.pow(base, power);
    }
    
    public double average(List<Integer> intList){
        double result = 0;
        for(Integer i : intList){
          result += i;
        }
        return (double) (result / intList.size());
    }
    
    public <T> T cast(Object obj, Class<T> c){
      return (T) obj;
    }
    
    public double average(int a, int b) {
       return (double) (a + b) / 2;
    }
    
    
    public char getLetterGrade(double mark){
        if(mark >= 80){
            return 'A';
        }else if (mark >= 70){
            return 'B';
        }else if (mark >= 60){
            return 'C';
        }else if (mark >= 50){
            return 'D';
        }else{
            return 'F';
        }
    }
    
    public double divide(int i1, int i2){
      return i1 / i2;
    }
    
    
    
}
