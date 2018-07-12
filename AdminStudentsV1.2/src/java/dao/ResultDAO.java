/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ResultDAO extends ConnectionDAO implements ResultDAOInterface {
    
    @Override
    public Result findById(Result result) throws SQLException, ClassNotFoundException {
        String query = "select student_id, (first_name || ' ' || last_name) as student_name, course_id, "
                + "course_name, marks, semester from results join courses using (course_id) "
                + "join students using (student_id) "
                + "where course_id = ? and student_id = ? order by student_id, course_id";
        Result res;
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setInt(1, result.getCourse_id());
            ps.setInt(2, result.getStudent_id());
            try (ResultSet rset = ps.executeQuery()) {
                res = new Result();
                while(rset.next()){
                    res.setStudent_id(rset.getInt("student_id"));
                    res.setCourse_id(rset.getInt("course_id"));
                    res.setMarks(rset.getInt("marks"));
                    res.setSemester(rset.getInt("semester"));
                    res.setStudent_name(rset.getString("student_name"));
                    res.setCourse_name(rset.getString("course_name"));
                }
            }
        }
        closeConnection();
        return res;
    }

    @Override
    public void delete(Result result) throws SQLException, ClassNotFoundException {
        String query = "delete from cristal.results where course_id = ? and student_id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setInt(1, result.getCourse_id());
            ps.setInt(2, result.getStudent_id());
            ps.executeUpdate();
        }
        closeConnection();
    }

    @Override
    public void update(Result result) throws SQLException, ClassNotFoundException {
        String query = "update cristal.results set marks = ?,  semester = ? where course_id = ? and student_id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setInt(1, result.getMarks());
            ps.setInt(2, result.getSemester());
            ps.setInt(3, result.getCourse_id());
            ps.setInt(4, result.getStudent_id());
            ps.executeUpdate();
        }
        closeConnection();
    }

    @Override
    public int insert(Result result) throws SQLException, ClassNotFoundException {
        String query = "insert into cristal.results (student_id, course_id, marks, semester) values (?,?,?,?)";
        int res;
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setInt(1, result.getStudent_id());
            ps.setInt(2, result.getCourse_id());
            ps.setInt(3, result.getMarks());
            ps.setInt(4, result.getSemester());
            res = ps.executeUpdate();
        }
        closeConnection();
        return res;
    }

    @Override
    public List<Result> findAll() throws SQLException, ClassNotFoundException {
        String query = "select student_id, (first_name || ' ' || last_name) as student_name, course_id, course_name, marks, semester from results join courses using (course_id) join students using (student_id) order by student_id, course_id";
        List <Result> results = new ArrayList <>();
        try (PreparedStatement ps = getConnection().prepareStatement(query); ResultSet rset = ps.executeQuery()) {
            while(rset.next()){
                Result result = new Result();
                result.setStudent_id(rset.getInt("student_id"));
                result.setStudent_name(rset.getString("student_name"));
                result.setCourse_id(rset.getInt("course_id"));
                result.setCourse_name(rset.getString("course_name"));
                result.setMarks(rset.getInt("marks"));
                result.setSemester(rset.getInt("semester"));
                results.add(result);
            }
        }
        closeConnection();
        return results;
    }
    
}
