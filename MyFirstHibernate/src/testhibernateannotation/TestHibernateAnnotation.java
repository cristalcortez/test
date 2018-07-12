/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testhibernateannotation;

import bean.EmployeeXML;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
        
        //insert employee
        String quit = "n";
        while (!quit.equalsIgnoreCase("q"))
        {
            EmployeeXML employee = new EmployeeXML();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the employee first name:");
            employee.setFirstName(sc.next());
            System.out.print("Enter the employee last name:");
            employee.setLastName(sc.next());
            System.out.print("Enter the employee salary:");
            employee.setSalary(sc.nextInt());
            insert(employee);
            System.out.print("Enter q to quit or any other key to continue:");
            quit = sc.next();
        }
        
        List<EmployeeXML> all = loadall();
        for(EmployeeXML e : all)
        {
            System.out.println("First Name: " + e.getFirstName());
            System.out.println("Last Name: " + e.getLastName());
            System.out.println("Salary: " + e.getSalary() + "\n");
        }
        
        sessionFactory.close();
    }
    
   
    public static void insert (EmployeeXML e)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(e);
        session.getTransaction().commit();
        
        session.close();
    }
    
    public static EmployeeXML load (int id)
    {
        // Session session = sessionFactory.getCurrentSession();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        EmployeeXML emp = (EmployeeXML) session.load(EmployeeXML.class, id);
        Hibernate.initialize(emp);
        
        session.close();
        return emp;
    }
    
    public static List loadall ()
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "FROM EmployeeXML";
        Query query = session.createQuery(hql);
        List results = query.list();
        
        session.close();
        return results;
    }
    
}
