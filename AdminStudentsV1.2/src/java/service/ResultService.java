/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ResultDAO;
import java.sql.SQLException;
import java.util.List;
import model.Result;

/**
 *
 * @author user
 */
public class ResultService {
    
    private static ResultDAO resultDao;
    
    public ResultService() {
        resultDao = new ResultDAO();
    }
    
    public void insert(Result result) throws SQLException, ClassNotFoundException {
        resultDao.insert(result);
    }
    
    public void delete(Result result) throws SQLException, ClassNotFoundException {
        resultDao.delete(result);
    }
    
    public void update(Result result) throws SQLException, ClassNotFoundException {
        resultDao.update(result);
    }
    
    public List<Result> findAll() throws SQLException, ClassNotFoundException {
        List<Result> results = resultDao.findAll();
        return results;
    }
    
    public Result findById(Result result) throws SQLException, ClassNotFoundException {
        Result res = resultDao.findById(result);
        return res;
    }
    
    public ResultDAO resultDao() {
		return resultDao;
	}
    
}
