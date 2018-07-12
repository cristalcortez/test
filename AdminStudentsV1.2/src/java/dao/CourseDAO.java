/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Course;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class CourseDAO extends ConnectionDAO implements CourseDAOInterface{
    
    @Override
    public Course findById(int course_id) throws SQLException, ClassNotFoundException {
        String query = "select course_id, course_name from cristal.courses where course_id = ?";
        Course course;
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setInt(1, course_id);
            try (ResultSet rset = ps.executeQuery()) {
                course = new Course();
                while(rset.next()){
                    course.setCourse_id(rset.getInt("course_id"));
                    course.setCourse_name(rset.getString("course_name"));
                }
            }
        }
        closeConnection();
        return course;
    }

    @Override
    public void delete(int course_id) throws SQLException, ClassNotFoundException {
        String query = "delete from cristal.courses where course_id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setInt(1, course_id);
            ps.executeUpdate();
        }
        closeConnection();
    }

    @Override
    public void update(Course course) throws SQLException, ClassNotFoundException {
        String query = "update cristal.courses set course_name = ? where course_id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setString(1, course.getCourse_name());
            ps.setInt(2, course.getCourse_id());
            ps.executeUpdate();
        }
        closeConnection();
    }

    @Override
    public int insert(Course course) throws SQLException, ClassNotFoundException {
        String query = "insert into cristal.courses (course_id, course_name) values (courses_course_id_seq.nextval,?)";
        int result;
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setString(1, course.getCourse_name());
            result = ps.executeUpdate();
        }
        closeConnection();
        return result;
    }

    @Override
    public List<Course> findAll() throws SQLException, ClassNotFoundException {
        String query = "select course_id, course_name from cristal.courses order by course_id";
        List <Course> courses = new ArrayList <>();
        try (PreparedStatement ps = getConnection().prepareStatement(query); ResultSet rset = ps.executeQuery()) {
            while(rset.next()){
                Course course = new Course();
                course.setCourse_id(rset.getInt("course_id"));
                course.setCourse_name(rset.getString("course_name"));
                courses.add(course);
            }
        }
        closeConnection();
        return courses;
    }
    
}
