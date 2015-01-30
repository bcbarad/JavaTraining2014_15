package com.vl.training.sample;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SelectTable extends HttpServlet {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "mouni777";

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException {

            String db =request.getParameter("db");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            Connection conn = null;
            Statement stmt = null;
            try{
                //STEP 2: Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                //STEP 3: Open a connection
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306",USER, PASS);

                //STEP 4: Execute a query
                stmt = conn.createStatement();
                String sql = "use " + db;
                ResultSet rs = stmt.executeQuery(sql);
                sql = "show tables";
                rs = stmt.executeQuery(sql);

                //STEP 5: Extract data from result set
                if(rs != null) {
                    out.println("<center>" +
                            "<form name=select_table action=http://google.co.in>" +
                            "<select name=table>");
                    while(rs.next()){
                        String data = rs.getString("Tables_in_" + db);
                        out.println("<option value="+ data + ">" + data + "</option>");
                    }
                    out.print("</select>" +
                            "<input type=submit value=Go >");
                    out.print("</form>");
                }
                //STEP 6: Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)
                        stmt.close();
                }catch(SQLException se2){
                }// nothing we can do
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }//end try
        }//end doPost
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException {
            doPost(request,response);
        }
}//end FirstExample
