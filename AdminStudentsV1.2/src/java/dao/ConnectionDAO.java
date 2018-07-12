/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import service.NamingService;

/**
 *
 * @author user
 */
public class ConnectionDAO {
    
    private Connection connection = null;
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
       Class.forName("oracle.jdbc.driver.OracleDriver");
       NamingService ns = NamingService.getInstance();
       connection = DriverManager.getConnection((String) ns.getAttribute("url"), (String) ns.getAttribute("user"), (String) ns.getAttribute("password"));
       return connection;
    }
    
    public void closeConnection() throws SQLException{
       if (connection != null) connection.close();
    }
    
}
