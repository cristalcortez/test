/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author user
 */
public class EmployeeXML {
    
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    
    public EmployeeXML(){
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }
    
    @Override
    public String toString(){
       return "EmployeeXML{id="+ getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", salary=" + salary + "}";
    }
}
