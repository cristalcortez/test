/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Result;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author user
 */
public interface ResultDAOInterface {
    
    Result findById(Result result) throws SQLException, ClassNotFoundException;
    
    void delete (Result result) throws SQLException, ClassNotFoundException;
    
    void update (Result result) throws SQLException, ClassNotFoundException;
    
    int insert (Result result) throws SQLException, ClassNotFoundException;
    
    List <Result> findAll()throws SQLException, ClassNotFoundException;
}
