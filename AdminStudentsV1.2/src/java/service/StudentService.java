/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.StudentDAO;
import java.sql.SQLException;
import java.util.List;
import model.Student;

/**
 *
 * @author user
 */
public class StudentService {
 
    private static StudentDAO studentDao;
    
    public StudentService() {
        studentDao = new StudentDAO();
    }
    
    public void insert(Student student) throws SQLException, ClassNotFoundException {
        studentDao.insert(student);
    }
    
    public void delete(String id) throws SQLException, ClassNotFoundException {
        studentDao.delete(Integer.parseInt(id));
    }
    
    public void update(Student student) throws SQLException, ClassNotFoundException {
        studentDao.update(student);
    }
    
    public List<Student> findAll() throws SQLException, ClassNotFoundException {
        List<Student> students = studentDao.findAll();
        return students;
    }
    
    public Student findById(String id) throws SQLException, ClassNotFoundException {
        Student student = studentDao.findById(Integer.parseInt(id));
        return student;
    }
    
    public StudentDAO studentDao() {
		return studentDao;
	}
    
}
