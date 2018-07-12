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
        Employee e1 = (Employee) ctx.getBean("e1");
    	e1.displayInfo();
        Employee e2 = (Employee) ctx.getBean("e2");
    	e2.displayInfo();
    	ctx.close();
    }
}
