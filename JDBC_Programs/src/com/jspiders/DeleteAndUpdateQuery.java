package com.jspiders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteAndUpdateQuery {
		public static void main(String[] args) {
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_jdbc","root","root");
//				Statement stmt=con.createStatement();
//				String sql="delete from employee where id=1001";
//				stmt.execute(sql);
//				con.close();
//				System.out.println("successfully deleted");
//			} catch (ClassNotFoundException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
			update();
//			}
			
		}
		public static void update() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_jdbc","root","root");
				Statement stmt=con.createStatement();
				String sql="update student set name='madara' where id=5";
				stmt.executeUpdate(sql);
				con.close();
				System.out.println("updated successfully");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
}
