/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.CourseDAO;
import dao.CourseHibernate;
import java.sql.SQLException;
import java.util.List;
import model.Course;

/**
 *
 * @author user
 */
public class CourseService {
    
    private static CourseDAO courseDao;
    private static CourseHibernate courseHibernate;
    
    public CourseService() {
        courseDao = new CourseDAO();
        courseHibernate = new CourseHibernate();
    }
    
    public void insert(Course course) throws SQLException, ClassNotFoundException {
        courseDao.insert(course);
    }
    
    public void delete(String id) throws SQLException, ClassNotFoundException {
        courseDao.delete(Integer.parseInt(id));
    }
    
    public void update(Course course) throws SQLException, ClassNotFoundException {
        courseDao.update(course);
    }
    
    public List<Course> findAll() throws SQLException, ClassNotFoundException {
        //List<Course> courses = courseDao.findAll();
        List<Course> courses = courseHibernate.findAll();
        return courses;
    }
    
    public Course findById(String id) throws SQLException, ClassNotFoundException {
        //Course course = courseDao.findById(Integer.parseInt(id));
        Course course = courseHibernate.findById(Integer.parseInt(id));
        return course;
    }
    
    public CourseDAO courseDao() {
		return courseDao;
	}
    
}
