/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testhibernateannotation;

import bean.Employee;
import bean.Person;
import bean.Student;
import java.util.Date;
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
        
        Person person = new Person("Patrick","Laurin");
        session.save(person);
        
        Employee employee = new Employee(new Date(), "Research", "Hondo", "Konizuki");
        session.save(employee);
        
        Student student = new Student(87, "Kanda", "Sorata");
        session.save(student);
        
        session.getTransaction().commit();
        session.close();
    }    
    
    
    
}
