/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Course;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author user
 */
public interface CourseDAOInterface {
    
    Course findById(int course_id) throws SQLException, ClassNotFoundException;
    
    void delete (int course_id) throws SQLException, ClassNotFoundException;
    
    void update (Course course) throws SQLException, ClassNotFoundException;
    
    int insert (Course course) throws SQLException, ClassNotFoundException;
    
    List <Course> findAll()throws SQLException, ClassNotFoundException;
    
}
