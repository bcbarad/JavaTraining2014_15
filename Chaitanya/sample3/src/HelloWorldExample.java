//package com.vl.training;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;
import java.util.*;
import java.io.FileNotFoundException;
public class HelloWorldExample extends HttpServlet {
  Properties p = null;
  public void init() throws ServletException {
    try {
        p = new Properties();
        p.load(getServletContext().getResourceAsStream("WEB-INF/resources/check.properties"));
    }
    catch(FileNotFoundException e) {
        e.printStackTrace();
    }
    catch(IOException e) {
        e.printStackTrace();
    }
  }

  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String clname = request.getParameter("username");
      String  clpwd = request.getParameter("password");
      Enumeration e = p.keys();
      boolean flag = false;
      while (e.hasMoreElements()) {
          String dbname = (String) e.nextElement();
          String dbpwd = p.getProperty(dbname);
          if ( dbname.equals(clname) && dbpwd.equals(clpwd)) {
              flag = true;
              break;
          }
      }
      if (flag) { 
          RequestDispatcher rd=request.getRequestDispatcher("Profile");
          rd.forward(request, response);
      } else{  
          out.print("Invalid username or password");  
          RequestDispatcher rd=request.getRequestDispatcher("index.html");  
          rd.include(request, response);  
      }  
      
  }
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
doPost(request, response);
  }
  public void destroy()
  {
      // do nothing.
  }
}

