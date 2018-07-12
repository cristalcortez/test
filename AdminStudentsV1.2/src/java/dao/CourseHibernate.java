/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Course;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author user
 */
public class CourseHibernate {
    
    static SessionFactory sessionFactory;
    
    public Course findById (int course_id)
    {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Course course = (Course) session.load(Course.class, course_id);
        Hibernate.initialize(course);
        
        session.close();
        return course;
    }
    
    public List<Course> findAll()
    {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "FROM Course";
        Query query = session.createQuery(hql);
        List<Course> results = query.list();
        
        session.close();
        return results;
    }
    
}
