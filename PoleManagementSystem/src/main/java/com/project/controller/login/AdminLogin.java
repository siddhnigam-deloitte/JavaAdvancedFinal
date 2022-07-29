package com.project.controller.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("Adminuname");
		String password=request.getParameter("Apassword");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/userdb","root","Password@123");
			Statement stmt=con.createStatement();
			ResultSet resultSet=stmt.executeQuery("select * from admin where Adminname='" + userName+ "' and password='"+password+"'");
			response.sendRedirect("DisplayComplaints");

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
