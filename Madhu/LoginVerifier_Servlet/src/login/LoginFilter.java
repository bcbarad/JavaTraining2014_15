package login;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;     
public class LoginFilter extends HttpServlet implements Filter {  
    public void init(FilterConfig arg0) throws ServletException {
    }    
    static int count=0;      
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {   
        PrintWriter out = response.getWriter();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(true);
        if(session.isNew()) {
           out.print("filter started.............");          
           //chain.doFilter(request, response);//sends request to next resource 
           chain.doFilter(request,response);    
           out.print("<br/>Total visitors "+(++count));    
           out.print("filter ended.............");
        } else {
            RequestDispatcher rd=request.getRequestDispatcher("index.html");  
            rd.include(request, response); 
        }
    }  
    public void destroy() {
    }  
}  
