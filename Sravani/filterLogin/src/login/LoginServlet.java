package login;
import java.util.Enumeration;
import java.util.Properties;
import java.io.IOException;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request , HttpServletResponse response)
        throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            //Get values using session
            response.setContentType("text/html");
            String uname = request.getParameter("user");
            String password = request.getParameter("password");
            HttpSession session=request.getSession();
            session.setAttribute("name",uname); 
            Properties properties = new Properties();
            properties.load(getServletContext().getResourceAsStream("/WEB-INF/resources/login.properties"));
            String pass = properties.getProperty(uname,password);
            if(pass.equals(password)){
                RequestDispatcher rd=request.getRequestDispatcher("BirthdayServlet");
                rd.forward(request, response);
            } else {
                out.print("username or password error!");  
            RequestDispatcher rd=request.getRequestDispatcher("index.html");  
            rd.include(request, response);
            }
        }
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException {
            doPost(request, response);
        }
}
