/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author user
 */
public enum CoursePages {
    
    LIST, INSERT_OR_EDIT;
    
    @Override
    public String toString(){
        switch(this){
            case LIST: return "/admin/coursesList.jsp";
            case INSERT_OR_EDIT: return "/admin/course.jsp";
            default : return "";
        }
    }
    
}
