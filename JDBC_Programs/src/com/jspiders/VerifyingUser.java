package com.jspiders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class VerifyingUser {
		public static void main(String[] args) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_jdbc","root","root");
			Statement stmt=con.createStatement();
			Scanner os=new Scanner(System.in);
			System.out.println("enter your email: ");
			String email=os.next();
			System.out.println("enter your password : ");
			String pwd=os.next();
			
			String sql="select * from user where mail='"+email+"' and pwd='"+pwd+"'";
			ResultSet rs=stmt.executeQuery(sql);
			
			if(rs.next())
				System.out.println("welcome to homepage");
			else
				System.out.println("invalid username or password");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
