package com.jspiders;

import java.sql.*;


public class FetchingData {
		public static void main(String[] args) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_jdbc","root","root");
				Statement stmt= con.createStatement();
				String sql="select * from student";
				ResultSet rs= stmt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getInt("id"));
					System.out.println(rs.getString("name"));
					System.out.println(rs.getInt("age"));
					System.out.println(rs.getLong("mobile"));
					System.out.println("-----------------------");
					
				}
				
			
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		}
		}

