package com.project.complaint.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/userdb","root","Password@123");
			String s="confirmed";
			Statement stmt = con.createStatement();
			int cid=Integer.parseInt(request.getParameter("cid"));
			int result=stmt.executeUpdate("update complaint set status='"+s+"' where cid='"+cid+"'");
			PrintWriter out=response.getWriter();
			if(result>0) {
				out.print("<H1>Status Updated</H1>");
			
			}else {
				out.print("<H1>Some error occured</H1>");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
