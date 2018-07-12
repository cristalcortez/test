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
public class Result {
    
    private int student_id;
    private String student_name;
    private int course_id;
    private String course_name;
    private int marks;
    private int semester;
    

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
    
    public int getStudent_id() {
        return student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getMarks() {
        return marks;
    }

    public int getSemester() {
        return semester;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getStudent_name() {
        return student_name;
    }
    
           
    @Override
    public String toString(){
        return "Results {" + "student_id = " + student_id + ", student_name = " + student_name + ", course_id = " + course_id + ", course_name = " + course_name + ", marks = " + marks + ", semester = " + semester +"}";
    }
    
}
