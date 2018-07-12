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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Result;
import service.ResultService;
import util.ErrorPages;
import util.ResultPages;

/**
 *
 * @author user
 */
@WebServlet(name = "ResultController", urlPatterns = {"/Mark"})
public class ResultController extends HttpServlet{
    
    private final ResultService resultService;
    
    public ResultController() {
        super();
        resultService = new ResultService();
    }
    
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      request.setAttribute("active", "result");
      String action = (request.getParameter("action") == null ? "" : request.getParameter("action"));
      Result result;
      if (action.equalsIgnoreCase("save")){
        try {
          result = new Result();
          result.setStudent_id(Integer.parseInt(request.getParameter("student_id")));
          result.setCourse_id(Integer.parseInt(request.getParameter("course_id")));
          result.setMarks(Integer.parseInt(request.getParameter("marks")));
          result.setSemester(Integer.parseInt(request.getParameter("semester")));

          resultService.insert(result);
          request.setAttribute("results", resultService.findAll());
          getServletContext().getRequestDispatcher(ResultPages.LIST.toString()).forward(request, response);
        }catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("error", ex);
            getServletContext().getRequestDispatcher(ErrorPages.ERROR_PAGE.toString()).forward(request, response);
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
      }else{
          getServletContext().getRequestDispatcher(ResultPages.INSERT_OR_EDIT.toString()).forward(request, response);
      }
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    request.setAttribute("active", "result");
    String action = (request.getParameter("action") == null ? "" : request.getParameter("action"));
    Result result;
   if (action.equalsIgnoreCase("delete")){
      try {
          result = new Result();
          result.setStudent_id(Integer.parseInt(request.getParameter("student_id")));
          result.setCourse_id(Integer.parseInt(request.getParameter("course_id")));
          resultService.delete(result);
          request.setAttribute("results", resultService.findAll());
          getServletContext().getRequestDispatcher(ResultPages.LIST.toString()).forward(request, response);
      }catch (SQLException | ClassNotFoundException ex) {
          request.setAttribute("error", ex);
          getServletContext().getRequestDispatcher(ErrorPages.ERROR_PAGE.toString()).forward(request, response);
          Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }else if(action.equalsIgnoreCase("edit")){
      try {
          result = new Result();
          result.setStudent_id(Integer.parseInt(request.getParameter("student_id")));
          result.setCourse_id(Integer.parseInt(request.getParameter("course_id")));
          request.setAttribute("action", "edit");
          request.setAttribute("result", resultService.findById(result));
          getServletContext().getRequestDispatcher(ResultPages.INSERT_OR_EDIT.toString()).forward(request, response);
      }catch (SQLException | ClassNotFoundException ex) {
          request.setAttribute("error", ex);
          getServletContext().getRequestDispatcher(ErrorPages.ERROR_PAGE.toString()).forward(request, response);
          Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }else if(action.equalsIgnoreCase("update")){
      try {
        result = new Result();
        result.setStudent_id(Integer.parseInt(request.getParameter("student_id")));
        result.setCourse_id(Integer.parseInt(request.getParameter("course_id")));
        result.setMarks(Integer.parseInt(request.getParameter("marks")));
        result.setSemester(Integer.parseInt(request.getParameter("semester")));
        resultService.update(result);
        request.setAttribute("results", resultService.findAll());
        getServletContext().getRequestDispatcher(ResultPages.LIST.toString()).forward(request, response);
      }catch (SQLException | ClassNotFoundException ex) {
          request.setAttribute("error", ex);
          getServletContext().getRequestDispatcher(ErrorPages.ERROR_PAGE.toString()).forward(request, response);
          Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }else{
      try {
          request.setAttribute("results", resultService.findAll());
          getServletContext().getRequestDispatcher(ResultPages.LIST.toString()).forward(request, response);

      } catch (SQLException | ClassNotFoundException ex) {
          request.setAttribute("error", ex);
          getServletContext().getRequestDispatcher(ErrorPages.ERROR_PAGE.toString()).forward(request, response);
          Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
