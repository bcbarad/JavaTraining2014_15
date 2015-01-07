import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;   
public class LoginServlet extends HttpServlet {  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setContentType("text/html");  
        String name = request.getParameter("name");
        String pass = request.getParameter("password");
        PrintWriter out = response.getWriter();      
        Properties properties = new Properties();
        properties.load(getServletContext().getResourceAsStream("/WEB-INF/resources/login.properties"));
        Enumeration e = properties.keys();
        boolean flag = false;
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = properties.getProperty(key);
            if ( key.equals(name) && value.equals(pass)) {
                flag = true;
                break;
            }
        }   
        if (flag) { 
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
