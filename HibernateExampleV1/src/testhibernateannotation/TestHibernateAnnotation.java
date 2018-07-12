/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testhibernateannotation;

import bean.Employee;
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
        
        /*insert employee
        String quit = "n";
        while (!quit.equalsIgnoreCase("q")){
            Employee employee = new Employee();
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
        }*/
        
        /* load from db by id 
        EmployeeXML employee = new EmployeeXML();
        employee = load(1);
        System.out.println("First Name: " + employee.getFirstName());
        System.out.println("Last Name: " + employee.getLastName());
        System.out.println("Salary: " + employee.getSalary());
        */
        
        /* load all row from db 
        List<Employee> all = loadall();
        for(Employee e : all)
        {
            System.out.println("First Name: " + e.getFirstName());
            System.out.println("Last Name: " + e.getLastName());
            System.out.println("Salary: " + e.getSalary() + "\n");
        }
        
        sessionFactory.close();*/
        
        //Prep Work
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		//Get Example
		Employee emp = (Employee) session.get(Employee.class, new Long(0));
		System.out.println("Employee get called");
		System.out.println("Employee ID= "+emp.getId());
		System.out.println("Employee Get Details:: "+emp+"\n");
		
		//load Example
		Employee emp1 = (Employee) session.load(Employee.class, new Long(1));
		System.out.println("Employee load called");
		System.out.println("Employee ID= "+emp1.getId());
		System.out.println("Employee load Details:: "+emp1+"\n");
		
		//Close resources
		tx.commit();
		sessionFactory.close();
        
    }    
    
    public static void insert (Employee e)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(e);
        session.getTransaction().commit();
        
        session.close();
    }
    
   
    public static Employee load (int id)
    {
        // Session session = sessionFactory.getCurrentSession();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Employee emp = (Employee) session.load(Employee.class, id);
        Hibernate.initialize(emp);
        
        session.close();
        return emp;
    }
    
    public static List loadall ()
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "FROM Employee";
        Query query = session.createQuery(hql);
        List results = query.list();
        
        session.close();
        return results;
    }
    
}
