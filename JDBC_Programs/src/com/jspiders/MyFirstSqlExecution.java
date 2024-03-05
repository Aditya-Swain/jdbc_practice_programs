package com.jspiders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class MyFirstSqlExecution {
		public static void main(String[] args) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");			
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_jdbc","root","root");
				Statement stmt=con.createStatement();
				String sql="INSERT INTO student(id,name,age,mobile) VALUES(8,'might',46,8755765874)";
				
				stmt.execute(sql);
				con.close();
				System.out.println("data has been inserted successfully");
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		}
}
