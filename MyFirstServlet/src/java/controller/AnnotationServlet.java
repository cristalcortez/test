package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AnnotationServlet", urlPatterns = {"/annotation"})
public class AnnotationServlet extends HttpServlet{
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
     GregorianCalendar currentDate = new GregorianCalendar();
     int currentYear = currentDate.get(Calendar.YEAR);
     request.setAttribute("currentYear", currentYear);
     request.setAttribute("Name1", request.getAttribute("Name"));
     request.setAttribute("Name2", "cristal");
     //getServletContext().getRequestDispatcher("/annotationJSTL.jsp").forward(request, response);
     getServletContext().getRequestDispatcher("/annotation.jsp").forward(request, response);
   }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
     response.setContentType("text/html");
     PrintWriter out = response.getWriter();
     try{
         out.println("<h1>HTML from AnnotationServlet</h1>");
     }finally{
         out.close();
     }
   }
}
