package com.project.repository.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.entity.registration.AdminRegisterEntity;
import com.project.entity.registration.RegisterEntity;

public class AdminReposDao {
	
	
	public String insert(AdminRegisterEntity adminRegisterEntity) 
	{

		
		PreparedStatement ps;
		String result = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","Password@123");
			Statement stmt=con.createStatement();
			String sql = "insert into admin values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, adminRegisterEntity.getAuname());
			ps.setString(2, adminRegisterEntity.getPassword());
			ps.setString(3, adminRegisterEntity.getEmail());
			ps.setString(4, adminRegisterEntity.getPhone());
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
