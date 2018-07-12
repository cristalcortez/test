/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class Student {
    
    private int student_id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String create_date;

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public int getStudent_id() {
        return student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getCreate_date() {
        return create_date;
    }

    public String getGender() {
        return gender;
    }

    
    @Override
    public String toString(){
        return "Student {" + "student_id = " + student_id + ", name = " + first_name + " " + last_name + "}";
    }
    
}
