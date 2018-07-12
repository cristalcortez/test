/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testhibernateannotation;

import bean.Author;
import bean.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author user
 */
public class TestHibernateAnnotation {
    
    static SessionFactory sessionFactory;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        /*Author a1 = new Author(); 
        a1.setName("Author 1");
        a1.setEmail("a1@cox.com");
          
        Author a2 = new Author(); 
        a2.setName("Author 2");
        a2.setEmail("a2@cox.com");
        
        Set<Author> authors = new HashSet<Author>();
        authors.add(a1);
        authors.add(a2);
        
        System.out.println(authors.toString());
        
        Book b1 = new Book();
        b1.setTitle("Book 1");
        b1.setDescription("Desc of Book 1");
        Date today = new Date();
        b1.setPublishedDate(today);
        b1.setAuthors(authors);
                
        session.save(b1);*/
        
        Query query = session.createQuery("from Book where id = 1");

        List result = query.list();

            System.out.println("resultset:"+result);

            Iterator iterator = result.iterator();
            while(iterator.hasNext()){
                Book book = (Book) iterator.next();
 
                 System.out.println(book.toString());
            }
        //session.getTransaction().commit();
        
        session.close();
    }    
    
    
    
}
