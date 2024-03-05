package com.jspiders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class VerifyingUser2 {
		public static void main(String[] args) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_jdbc","root","root");
				Statement stmt=con.createStatement();
				
				Scanner os= new Scanner(System.in);
				System.out.println("enter your email: ");
				String email=os.next();
				System.out.println("enter your password:");
				String pwd=os.next();
				
				String sql="select * from user where mail='"+email+"'";
				
				ResultSet rst =stmt.executeQuery(sql);
				
				if(rst.next())
				{
					String dbpwd=rst.getString("pwd");
					if(pwd.equals(dbpwd))
						System.out.println("Welcome to home page");
					else
						System.out.println("Invalid password");
					
				}
				else
				{
					System.out.println("Invalid email id");
				}
				con.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
