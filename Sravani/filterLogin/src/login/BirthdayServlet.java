package login;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Enumeration;
import java.text.SimpleDateFormat;
public class BirthdayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        out.println("<html><body><form action=\"ProfileServlet\" method=\"post\">");
        out.println("Date of Birth");
        out.println("<input type = \"text\" name=\"date\"/>");
        out.println("<input type=\"submit\" name=\"submit\">");
        out.println("</form></body></html>");
        
    }
}

