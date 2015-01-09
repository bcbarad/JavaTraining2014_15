package login;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
public class MyFilter implements Filter{
    public void init(FilterConfig arg0) throws ServletException {}
    public void doFilter(ServletRequest req, ServletResponse res , FilterChain chain) throws IOException, ServletException {
         PrintWriter out=res.getWriter();
         out.println("filter started");
         //RequestDispatcher rd=req.getRequestDispatcher("index.html");
         chain.doFilter(req , res);
         out.println("filter ended");
    }
    public void destroy() {}
}
