/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testhibernateannotation;

import bean.Product;
import bean.Supplier;
import java.text.NumberFormat;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 *
 * @author user
 */
public class TestHibernateAnnotation {
    
    static SessionFactory sessionFactory;

    public static void main(String[] args) {
        
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        /*Supplier s1 = new Supplier("Phoenix");
        Product p1 = new Product("INC 100", "Neonatal intensive");*/
        
        
        session.getTransaction().commit();
        session.close();

    }    
    
    
    
}
