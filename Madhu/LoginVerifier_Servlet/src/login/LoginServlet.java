package login;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;   
public class LoginServlet extends HttpServlet { 
    Properties properties = new Properties();
    public void init(ServletConfig config) throws ServletException {
            super.init(config);
            try {
            properties.load(getServletContext().getResourceAsStream("/WEB-INF/resources/login.properties"));
         } catch(Exception ie) {
             ie.printStackTrace();
         }
    } 
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setContentType("text/html");  
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();      
        String pass = properties.getProperty(name," ");  
        if (pass.equals(password)) { 
            RequestDispatcher rd=request.getRequestDispatcher("Profile");
            rd.forward(request, response);
        } else{  
            out.print("username or password error!");  
            RequestDispatcher rd=request.getRequestDispatcher("index.html");  
            rd.include(request, response);  
        }  
        out.close();         
    }  
}  
