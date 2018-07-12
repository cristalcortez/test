/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class LoginFilter implements Filter {
    
    private FilterConfig filterConfig;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
        this.filterConfig = filterConfig;

    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
  
       HttpServletRequest req = (HttpServletRequest)request;
       HttpServletResponse res = (HttpServletResponse)response;

       String username = req.getRemoteUser();
       System.out.println("username" + username);

       chain.doFilter(request, response);

       
    }
    
    @Override
    public void destroy(){
        
        filterConfig = null;
    }
   

    
}
