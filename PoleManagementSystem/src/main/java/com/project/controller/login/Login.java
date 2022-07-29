package com.project.controller.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("uname");
		String password=request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/userdb","root","Password@123");
			Statement stmt=con.createStatement();
			ResultSet resultSet=stmt.executeQuery("select * from member where email='" + userName+ "' and password='"+password+"'");
			response.sendRedirect("complaintservlet.jsp?usern="+userName);

			//request.getRequestDispatcher("ComplaintServlet");



//			if(resultSet.next()) {
//				request.setAttribute("message","Welcome to InterServletCommunication"+userName);
//				requestDispatcher.forward(request,response);
//			}
//			else {
//				requestDispatcher = request.getRequestDispatcher("login.html");
//				requestDispatcher.include(request,response);
//			}
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			System.out.println("xyzzzzz");
		}
	}
	

}
