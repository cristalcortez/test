/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
*
* @author user
*/
public class ConnectionFactory {

private static Connection connection=null;

public static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
public static final String USER="hr";
public static final String PASS="oracle";

public static Connection getConnection() throws ClassNotFoundException{
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
connection=DriverManager.getConnection(URL,USER,PASS);
return connection;
}
catch(SQLException ex){
throw new RuntimeException("Error connectiong to the database",ex);
}
}

public void closeConnection() throws SQLException{
if(connection !=null){
connection.close();
}
}
}