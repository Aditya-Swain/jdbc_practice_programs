package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.org.dto.Customer;

public class CustomerDao {
		private static Connection con;
		static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/first_sql","root","root");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		public String insertData(Customer customer)
		{
			String name = customer.getName();
			int age = customer.getAge();
			long mobile = customer.getMobile();
			if(con!=null) {
			try {
				PreparedStatement pst = con.prepareStatement("insert into student(name,age,mobile) values(?,?,?)");
				pst.setString(1, name);
				pst.setInt(2, age);
				pst.setLong(3, mobile);
				int rows = pst.executeUpdate();
				pst.close();
				return rows+" row(s) updated ";
			}
			
			 catch (SQLException e) {
				e.printStackTrace();
			}
			}
			return "something went wrong";
		}
		public void fetchData() {
			try {
				PreparedStatement pst = con.prepareStatement("select * from student");
				ResultSet rst = pst.executeQuery();
				while(rst.next()) {
					System.out.println("Name:"+rst.getString("name"));
					System.out.println("Age:"+rst.getInt("age"));
					System.out.println("Mobile:"+rst.getLong("mobile"));
					System.out.println("---------------------------------");
					
				}
				rst.close();
				pst.close();
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		public void closeConnection() {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
}

