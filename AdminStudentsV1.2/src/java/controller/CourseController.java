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
import model.Course;
import service.CourseService;
import util.CoursePages;
import util.ErrorPages;

/**
 *
 * @author user
 */
@WebServlet(name = "CourseController", urlPatterns = {"/Course"})
public class CourseController extends HttpServlet {
    
    //private static final String LIST = "/coursesList.jsp";
    //private static final String INSERT_OR_EDIT = "/course.jsp";
    private final CourseService courseService;
    
    public CourseController() {
        super();
        courseService = new CourseService();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      request.setAttribute("active", "course");
      String action = (request.getParameter("action") == null ? "" : request.getParameter("action"));
      Course course;
      if (action.equalsIgnoreCase("save")){
        try {
          course = new Course();
          course.setCourse_name(request.getParameter("course_name"));
          courseService.insert(course);
          request.setAttribute("courses", courseService.findAll());
          //getServletContext().getRequestDispatcher(LIST).forward(request, response);
          getServletContext().getRequestDispatcher(CoursePages.LIST.toString()).forward(request, response);
        }catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("error", ex);
            getServletContext().getRequestDispatcher(ErrorPages.ERROR_PAGE.toString()).forward(request, response);
            Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
      }else{
          getServletContext().getRequestDispatcher(CoursePages.INSERT_OR_EDIT.toString()).forward(request, response);
      }
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    request.setAttribute("active", "course");
    String action = (request.getParameter("action") == null ? "" : request.getParameter("action"));
    String course_id;
    Course course;
   if (action.equalsIgnoreCase("delete")){
      try {
          course_id = request.getParameter("course_id");
          courseService.delete(course_id);
          request.setAttribute("courses", courseService.findAll());
          getServletContext().getRequestDispatcher(CoursePages.LIST.toString()).forward(request, response);
      }catch (SQLException | ClassNotFoundException ex) {
          request.setAttribute("error", ex);
          getServletContext().getRequestDispatcher(ErrorPages.ERROR_PAGE.toString()).forward(request, response);
          Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }else if(action.equalsIgnoreCase("edit")){
      try {
          course_id = request.getParameter("course_id");
          request.setAttribute("action", "edit");
          request.setAttribute("course", courseService.findById(course_id));
          getServletContext().getRequestDispatcher(CoursePages.INSERT_OR_EDIT.toString()).forward(request, response);
      }catch (SQLException | ClassNotFoundException ex) {
          request.setAttribute("error", ex);
          getServletContext().getRequestDispatcher(ErrorPages.ERROR_PAGE.toString()).forward(request, response);
          Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }else if(action.equalsIgnoreCase("update")){
      try {
        course = new Course();
        course.setCourse_id(Integer.parseInt(request.getParameter("course_id")));
        course.setCourse_name(request.getParameter("course_name"));
        courseService.update(course);
        request.setAttribute("courses", courseService.findAll());
        getServletContext().getRequestDispatcher(CoursePages.LIST.toString()).forward(request, response);
      }catch (SQLException | ClassNotFoundException ex) {
          request.setAttribute("error", ex);
          getServletContext().getRequestDispatcher(ErrorPages.ERROR_PAGE.toString()).forward(request, response);
          Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }else{
      try {
          request.setAttribute("courses", courseService.findAll());
          getServletContext().getRequestDispatcher(CoursePages.LIST.toString()).forward(request, response);

      } catch (SQLException | ClassNotFoundException ex) {
          request.setAttribute("error", ex);
          getServletContext().getRequestDispatcher(ErrorPages.ERROR_PAGE.toString()).forward(request, response);
          Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}