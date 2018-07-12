/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StudentService;

/**
 *
 * @author user
 */
public class Test {
    
    public static void main(String[] args){
       
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService service = (StudentService) ctx.getBean("studentService");
        Student st = new Student();
        st.setFirstname("Cristal");
        service.addStudent(st);
      
    }
    
}
