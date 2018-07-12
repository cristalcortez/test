/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
public class StudentDAO extends ConnectionDAO implements StudentDAOInterface{
 
    @Override
    public Student findById(int student_id) throws SQLException, ClassNotFoundException {
        String query = "select student_id, first_name, last_name, email, gender, create_date from cristal.students where student_id = ?";
        Student student;
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setInt(1, student_id);
            try (ResultSet rset = ps.executeQuery()) {
                student = new Student();
                while(rset.next()){
                    student.setStudent_id(rset.getInt("student_id"));
                    student.setFirst_name(rset.getString("first_name"));
                    student.setLast_name(rset.getString("last_name"));
                    student.setEmail(rset.getString("email"));
                    student.setGender(rset.getString("gender"));
                    student.setCreate_date(rset.getString("create_date"));
                }
            }
        }
        closeConnection();
        return student;
    }
    
    @Override
    public void delete(int student_id) throws SQLException, ClassNotFoundException {
        String query = "delete from cristal.students where student_id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setInt(1, student_id);
            ps.executeUpdate();
        }
        closeConnection();
    }
    
    @Override
    public void update(Student student) throws SQLException, ClassNotFoundException {
        String query = "update cristal.students set first_name = ?, last_name = ?, email = ?, gender = ? where student_id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setString(1, student.getFirst_name());
            ps.setString(2, student.getLast_name());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getGender());
            ps.setInt(5, student.getStudent_id());
            ps.executeUpdate();
        }
        closeConnection();
    }
    
    @Override
    public int insert(Student student) throws SQLException, ClassNotFoundException {
        String query = "insert into cristal.students (student_id, first_name, last_name, email, gender, create_date) values (students_student_id_seq.nextval,?,?,?,?,sysdate)";
        int result;
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setString(1, student.getFirst_name());
            ps.setString(2, student.getLast_name());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getGender());
            result = ps.executeUpdate();
        }
        closeConnection();
        return result;
    }
    
    @Override
     public List <Student> findAll() throws SQLException, ClassNotFoundException {
        String query = "select student_id, first_name, last_name, email, create_date, gender from cristal.students order by student_id";
        List <Student> students = new ArrayList <>();
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ResultSet rset = ps.executeQuery();
            while(rset.next()){
                Student student = new Student();
                student.setStudent_id(rset.getInt("student_id"));
                student.setFirst_name(rset.getString("first_name"));
                student.setLast_name(rset.getString("last_name"));
                student.setEmail(rset.getString("email"));
                student.setCreate_date(rset.getString("create_date"));
                student.setGender(rset.getString("gender"));
                students.add(student);
            }
            rset.close();
        }
        closeConnection();
        return students;
    }
}
