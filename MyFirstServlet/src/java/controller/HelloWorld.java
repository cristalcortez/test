package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloWorld extends HttpServlet{
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
     GregorianCalendar currentDate = new GregorianCalendar();
     int currentYear = currentDate.get(Calendar.YEAR);
     request.setAttribute("currentYear", currentYear);
     request.setAttribute("Name", "Cristal from HelloWorld Servlet");
     //getServletContext().getRequestDispatcher("/annotation.jsp").forward(request, response);     
     getServletContext().getRequestDispatcher("/annotation").forward(request, response);     
     
  }
  
}
