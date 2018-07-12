/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterface;

import java.sql.SQLException;
import java.util.List;
import model.Person;

/**
 *
 * @author user
 */
public interface PersonDAO {
    void create(Person p);
    List<Person> findAll();
    Person findById(int id);
}
