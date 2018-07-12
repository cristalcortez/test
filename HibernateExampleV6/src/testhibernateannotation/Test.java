/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testhibernateannotation;

import bean.Employee;
import bean.Address;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author user
 */
public class Test {
    
    static SessionFactory sessionFactory;

    public static void main(String[] args) {
        
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        /*Employee e1 = new Employee("Amit", new Address("gzb", "India", 221233), 500);
        Employee e2 = new Employee("Viajay", new Address("noida", "India", 12), 800);
        Employee e3 = new Employee("Cristal", new Address("Montreal", "Canada", 43), 10000);
        Employee e4 = new Employee("Isaac", new Address("Montreal", "Canada", 96), 10000);
        
        session.save(e1);
        session.save(e2);
        session.save(e3);
        session.save(e4);
        
        session.getTransaction().commit();*/
        
        Criteria cr = session.createCriteria(Employee.class);  
        cr.add(Restrictions.gt("salary", 2000d));
        List<Employee> results = cr.list();
        
        /*System.out.println("Employees with salary greater than ");
        for(Employee e : results){
          System.out.println(e.toString());
        }*/
        
        System.out.println("Employees with salary greater than 2000");
        results.forEach((e) -> {
            System.out.println(e.toString());
        });
        
        
        session.close();
        System.exit(0);
    }    
    
    
    
}
