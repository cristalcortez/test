/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Student;
import java.sql.*;
import java.util.List;

/**
 *
 * @author user
 */
public interface StudentDAOInterface {
    
    Student findById(int student_id) throws SQLException, ClassNotFoundException;
    
    void delete (int student_id) throws SQLException, ClassNotFoundException;
    
    void update (Student student) throws SQLException, ClassNotFoundException;
    
    int insert (Student student) throws SQLException, ClassNotFoundException;
    
    List <Student> findAll()throws SQLException, ClassNotFoundException;
    
}
