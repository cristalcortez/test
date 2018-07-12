/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.StudentDAO;
import java.util.List;


import model.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */

@Service
public class StudentServiceImpl implements StudentService{
    
    private StudentDAO studentDAO;
    
    @Override
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional
    public void addStudent(Student s) {
        studentDAO.addStudent(s);
    }

    @Override
    @Transactional
    public void updateStudent(Student s) {
        studentDAO.updateStudent(s);
    }

    @Override
    @Transactional
    public List<Student> listStudents() {
        return studentDAO.listStudents();
    }

    @Override
    @Transactional
    public Student getStudentbyId(int id) {
        return studentDAO.getStudentbyId(id);
    }

    @Override
    @Transactional
    public void removeStudent(int id) {
        studentDAO.removeStudent(id);
    }
    
}
