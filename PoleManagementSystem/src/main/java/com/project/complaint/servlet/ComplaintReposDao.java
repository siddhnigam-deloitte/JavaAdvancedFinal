package com.project.complaint.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.entity.registration.RegisterEntity;

public class ComplaintReposDao {
	public String insert(ComplaintEntity complaintentity) 
	{

		
		PreparedStatement ps;
		String result = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","Password@123");
			Statement stmt=con.createStatement();
			String sql = "insert into complaint values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, complaintentity.getCid());
			ps.setInt(2, complaintentity.getPid());
			ps.setString(3, complaintentity.getComment());
			ps.setString(4, complaintentity.getUsername());
			ps.setString(5, complaintentity.getStatus());
			ps.executeUpdate();
			result="Complaint registered successfully";
			
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
