package com.project.repository.registration;

import com.project.entity.registration.RegisterEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterReposDAO {
//	private String dbUrl = "jdbc:mysql://localhost:3306/userdb";
//	private String dbUname = "root";
//	private String dbPassword = "Password@123";
//	private String dbDriver = "com.mysql.jdbc.Driver";
	
//	public void loadDriver(String dbDriver)
//	{
//		try {
//			Class.forName(dbDriver);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public Connection getConnection()
//	{
//		Connection con = null;
//		try {
//			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return con;
//	}
//	
	
	public String insert(RegisterEntity RegisterEntity) 
	{

		
		PreparedStatement ps;
		String result = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","Password@123");
			Statement stmt=con.createStatement();
			String sql = "insert into member values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, RegisterEntity.getUname());
			ps.setString(2, RegisterEntity.getPassword());
			ps.setString(3, RegisterEntity.getEmail());
			ps.setString(4, RegisterEntity.getPhone());
			ps.executeUpdate();
			result="Data entered successfully";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered";
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			result="xyz";
		} 
		return result;
	}
}
