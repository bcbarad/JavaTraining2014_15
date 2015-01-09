package login;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public class ProfileServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(false);
        String name=null;  
        if(session!=null){  
            name = (String)session.getAttribute("name");
        } else {
           out.print("Please login first");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }
        String dob = request.getParameter("date");
        Properties properties = new Properties();
        properties.load(getServletContext().getResourceAsStream("/WEB-INF/resources/bday.properties"));
        String dob1 = properties.getProperty(name, dob);
        if(dob1.equals(dob)){
            out.print("<html>");
            out.print("<body>");
            out.print("<h4> You are logged in successfully...</h4>");
        out.print("<form action=\"index.html\" method=\"post\">");
        out.print("<input type=\"submit\" name=\"submit\" value=\"Logout\">");
        out.print("</form>");
        out.print("</body>");
        out.print("</html>");
        } else {
            //Invalid User
            out.println("birth day date is wrong");
            request.getRequestDispatcher("/index.html").include(request, response);
        }
        
    }
}
