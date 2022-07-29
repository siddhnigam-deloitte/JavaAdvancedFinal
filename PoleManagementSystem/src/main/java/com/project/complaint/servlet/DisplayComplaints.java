package com.project.complaint.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayComplaints
 */
@WebServlet("/DisplayComplaints")
public class DisplayComplaints extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DisplayComplaints() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
        out.println("<html><body>");
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/userdb","root","Password@123");
			
			Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from complaint");  
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>ComplaintID</th><th>PoleID</th><th>Comment</th><th>UserName</th><th>Status</th><tr>");  
            while (rs.next()) 
            {  
                int n = rs.getInt("cid");  
                int nm = rs.getInt("pid");  
                String nmm = rs.getString("comment");
                String nmmm = rs.getString("username");
                String nmmmm = rs.getString("status");
                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + nmm + "</td><td>"+nmmm+"</td><td>"+nmmmm+"</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            out.println("error");  
        }  
        
        
	}

	
}
