import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;   
public class Profile extends HttpServlet {  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");         
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<body>");
        out.print("<h4> You are logged in successfully...</h4>");
        out.print("<form action=\"Logout\" method=\"post\">");
        out.print("Date of birth:<input type=\"date\" name=\"bday\" max=\"2015-01-01\">");
        out.print("<input type=\"submit\" name=\"submit\" value=\"Submit\">");
        out.print("</form>");
        out.print("</body>");
        out.print("</html>");
    }  
}  
