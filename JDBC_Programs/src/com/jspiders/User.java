package com.jspiders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
		public static void main(String[] args) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_jdbc","root","root");
				Statement stmt=con.createStatement();
				String sql="insert into user values(104,'hinata','hinata23@gmail.com','hinata234',7898765678)";
				stmt.execute(sql);
				con.close();
				System.out.println(" successfully inserted");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
