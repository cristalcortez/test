/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.StudentDAO;
import java.util.List;
import model.Student;

/**
 *
 * @author user
 */
public interface StudentService {
    
    public void setStudentDAO(StudentDAO studentDAO);
    public void addStudent(Student s);
    public void updateStudent(Student s);
    public List<Student> listStudents();
    public Student getStudentbyId(int id);
    public void removeStudent(int id);
}
