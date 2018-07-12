/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaceImplementation;

import connection.ConnectionFactory;
import daoInterface.PersonDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Person;

/**
 *
 * @author user
 */
public class PersonDAOImplementation implements PersonDAO{
    Connection connection;

    public PersonDAOImplementation() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    @Override
    public void create(Person p) {
        PreparedStatement preparedStatement = null;
        try{
          preparedStatement = connection.prepareStatement("insert into persons (id_person, first_name) values (persons_person_id_seq.nextval, ?)");
          preparedStatement.setString(1, p.getName());
          preparedStatement.executeUpdate();

          preparedStatement.close();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
//persons_person_id_seq
    @Override
    public List<Person> findAll() {
        Person person = null;
        List persons = new ArrayList<Person>();
 
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("select * from persons");
            resultSet = preparedStatement.executeQuery();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
           
            while(resultSet.next()){
                
                person = new Person();
                person.setId(resultSet.getInt("id_person"));
                person.setName(resultSet.getString("first_name"));

                persons.add(person);
            }
            resultSet.close();
            preparedStatement.close();

        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
  
        return persons;
    }

    @Override
    public Person findById(int person_id) {
        Person person = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("select * from persons where id_person = ?");
            preparedStatement.setInt(1, person_id);
            resultSet = preparedStatement.executeQuery();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            resultSet.next();
            person = new Person();
            person.setId(resultSet.getInt("id_person"));
            person.setName(resultSet.getString("first_name"));
            
            resultSet.close();
            preparedStatement.close();
  
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return person;
    }
    
    
    
}
