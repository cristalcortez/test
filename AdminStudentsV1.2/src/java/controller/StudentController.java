/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;
import service.StudentService;
import util.ErrorPages;
import util.StudentPages;

/**
 *
 * @author user
 */

public class StudentController extends HttpServlet{
    
    private final StudentService studentService;
    
    public StudentController() {
        super();
        studentService = new StudentService();
    }
    
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      request.setAttribute("active", "student");
      String action = (request.getParameter("action") == null ? "" : request.getParameter("action"));
      Student student;
      if (action.equalsIgnoreCase("save")){
        try {
          student = new Student();
          student.setFirst_name(request.getParameter("first_name"));
          student.setLast_name(request.getParameter("last_name"));
          student.setEmail(request.getParameter("email"));
          student.setGender(request.getParameter("gender"));
          studentService.insert(student);
          request.setAttribute("students", studentService.findAll());
          getServletContext().getRequestDispatcher(StudentPages.LIST.toString()).forward(request, response);
        }catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("error", ex);
            getServletContext().getRequestDispatcher(ErrorPages.ERROR_PAGE.toString()).forward(request, response);
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
      }else{
          getServletContext().getRequestDispatcher(StudentPages.INSERT_OR_EDIT.toString()).forward(request, response);
      }
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    request.setAttribute("active", "student");
    String action = (request.getParameter("action") == null ? "" : request.getParameter("action"));
    String student_id;
    Student student;
   if (action.equalsIgnoreCase("delete")){
      try {
          student_id = request.getParameter("student_id");
          studentService.delete(student_id);
          request.setAttribute("students", studentService.findAll());
          getServletContext().getRequestDispatcher(StudentPages.LIST.toString()).forward(request, response);
      }catch (SQLException | ClassNotFoundException ex) {
          request.setAttribute("error", ex);
          getServletContext().getRequestDispatcher(ErrorPages.ERROR_PAGE.toString()).forward(request, response);
          Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }else if(action.equalsIgnoreCase("edit")){
      try {
          student_id = request.getParameter("student_id");
          request.setAttribute("action", "edit");
          request.setAttribute("student", studentService.findById(student_id));
          getServletContext().getRequestDispatcher(StudentPages.INSERT_OR_EDIT.toString()).forward(request, response);
      }catch (SQLException | ClassNotFoundException ex) {
          request.setAttribute("error", ex);
          getServletContext().getRequestDispatcher(ErrorPages.ERROR_PAGE.toString()).forward(request, response);
          Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }else if(action.equalsIgnoreCase("update")){
      try {
        student = new Student();
        student.setStudent_id(Integer.parseInt(request.getParameter("student_id")));
        student.setFirst_name(request.getParameter("first_name"));
        student.setLast_name(request.getParameter("last_name"));
        student.setEmail(request.getParameter("email"));
        student.setGender(request.getParameter("gender"));
        studentService.update(student);
        request.setAttribute("students", studentService.findAll());
        getServletContext().getRequestDispatcher(StudentPages.LIST.toString()).forward(request, response);
      }catch (SQLException | ClassNotFoundException ex) {
          request.setAttribute("error", ex);
          getServletContext().getRequestDispatcher(ErrorPages.ERROR_PAGE.toString()).forward(request, response);
          Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }else{
      try {
          request.setAttribute("students", studentService.findAll());
          getServletContext().getRequestDispatcher(StudentPages.LIST.toString()).forward(request, response);

          //Principal principal = request.getUserPrincipal();
          //System.out.println("j_username A " + principal.getName());

      } catch (SQLException | ClassNotFoundException ex) {
          request.setAttribute("error", ex);
          getServletContext().getRequestDispatcher(ErrorPages.ERROR_PAGE.toString()).forward(request, response);
          Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
