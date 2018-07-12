/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testhibernateannotation;

import bean.Country;
import bean.Capital;
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
        /*Session ss = sessionFactory.openSession();
        Country countryIndia = new Country("India",50000000);
        Capital capitalDelhi = new Capital("Delhi",4000000);
        capitalDelhi.setCountry(countryIndia);
        
        Country countryFrance = new Country("France",20000000);
        Capital capitalParis = new Capital("Paris",1000000);
        capitalParis.setCountry(countryFrance);
        
        ss.beginTransaction();
        ss.save(countryIndia);
        ss.save(capitalDelhi);
        ss.save(countryFrance);
        ss.save(capitalParis);
        ss.getTransaction().commit();
        ss.close();*/
        
        loadCapital("Paris");
        loadCountry("France");
        
        
    }    
    
    public static void loadCapital (String id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Capital capital = (Capital) session.load(Capital.class, id);
        Hibernate.initialize(capital);

        System.out.println("Capital Name: " + capital.getCapitalName());
        System.out.println("Capital Population: " + capital.getCapitalPopulation());
       
        session.close();
    }
    
    public static void loadCountry (String id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Country country = (Country) session.load(Country.class, id);
        Hibernate.initialize(country);

        System.out.println("Country Name: " + country.getCountryName());
        System.out.println("Country Population: " + country.getCountryPopulation());
       
        session.close();
    }
    
}
