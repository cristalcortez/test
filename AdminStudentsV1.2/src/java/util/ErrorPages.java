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
public enum ErrorPages {
    ERROR_PAGE;
    
    @Override
    public String toString(){
        switch(this){
            case ERROR_PAGE: return "/admin/error.jsp";
            default : return "";
        }
    }
}
