/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springexample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author user
 */
public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee e = (Employee) ctx.getBean("obj1");
       	e.displayInfo();
        ctx.close();
    }
}
